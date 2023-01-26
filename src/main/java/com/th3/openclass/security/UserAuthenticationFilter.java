package com.th3.openclass.security;

import com.th3.openclass.util.TokenHandler;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * This class checks for the authorization header and authenticates the JWT token and sets the authentication in the context.
 * Doing so will protect our APIs from those requests which do not have any authorization token.
 * The configuration about which resource to be protected and which not can be configured
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private TokenHandler tokenHandler;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Get JWT from the authorization header
        String header = request.getHeader("Authorization");
        String email = null;
        String authToken = null;

        // if request has JWT, start with Bearer  then remove it
        if (header != null && header.startsWith("Bearer ")) {
            authToken = header.replace("Bearer ","");
            try {
                // and parse email from it
                email = tokenHandler.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("an error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("the token is expired and not valid anymore", e);
            } catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            }
        } else {
            logger.warn("couldn't find bearer string, will ignore the header");
        }
        /**
         * {@link https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html#servlet-authentication-securitycontextholder link} for more movement details
         */
        // SecurityContextHolder.getContext().getAuthentication() contains an Authentication object
        // If it contains a value, then it is used as the currently authenticated user from SecurityContextHolder see link
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if (tokenHandler.validateToken(authToken, userDetails)) {

                // Get email and password from login request AuthenticationManager will use it to authenticate a login account
                // and AuthenticationManager help of UserDetailsService and PasswordEncoder to validate
                UsernamePasswordAuthenticationToken authentication = tokenHandler.getAuthentication(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("authenticated user " + email + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);

    }
}