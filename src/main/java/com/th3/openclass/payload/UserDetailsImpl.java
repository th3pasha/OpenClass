package com.th3.openclass.payload;

import com.th3.openclass.model.Account;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Getter
public class UserDetailsImpl implements UserDetails {
    private String userId;
    private String email;
    private String password;
    private GrantedAuthority authorities;

    public UserDetailsImpl(String userId, String email, String password, GrantedAuthority authorities) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserDetailsImpl build(Account account){
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + account.getRole().name());
        return new UserDetailsImpl(
                account.getStudent().getId(),
                account.getStudent().getEmail(),
                account.getStudent().getPassword(),
                authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(authorities);
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
