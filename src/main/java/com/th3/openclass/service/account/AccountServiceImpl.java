package com.th3.openclass.service.account;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.model.Account;
import com.th3.openclass.model.Student;
import com.th3.openclass.payload.JwtResponse;
import com.th3.openclass.payload.UserDetailsImpl;
import com.th3.openclass.repository.AccountRepository;
import com.th3.openclass.repository.StudentRepository;
import com.th3.openclass.security.UserDetailsServiceImpl;
import com.th3.openclass.util.JSONUtil;
import com.th3.openclass.util.TokenHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenHandler tokenHandler;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public Account register(StudentCommand studentCommand) {
        studentCommand.validate();
        log.info("Begin creating student with payload {}", JSONUtil.toJSON(studentCommand));
        final Student student = studentRepository.save(Student.create(studentCommand));
        student.setPassword(passwordEncoder.encode(studentCommand.getPassword()));
        final Account account = accountRepository.save(Account.create(student));
        return account;
    }

    @Override
    public JwtResponse login(StudentCommand studentCommand) {
        // If the authentication process is successful,
        // we can get Users information such as email, password, authorities from an Authentication
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(studentCommand.getEmail(), studentCommand.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl base = (UserDetailsImpl) authentication.getPrincipal();

        final UserDetails userDetails = userDetailsService.loadUserByUsername(studentCommand.getEmail());
        List<String> roles = base.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        final String token = tokenHandler.generateToken(userDetails);
        log.info("token : {}", token);
        log.info("authority {}", userDetails.getAuthorities());
        return new JwtResponse(base.getUserId(), token, base.getUsername(), roles);
    }
    @Override
    public Account getProfile() {
        return null;
    }
}
