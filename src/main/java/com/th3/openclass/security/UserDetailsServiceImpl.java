package com.th3.openclass.security;

import com.th3.openclass.exception.BusinessException;
import com.th3.openclass.exception.ExceptionPayloadFactory;
import com.th3.openclass.model.Account;
import com.th3.openclass.payload.UserDetailsImpl;
import com.th3.openclass.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Account account = accountRepository.findAccountByStudentEmail(email).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.STUDENT_NOT_FOUND.get())
        );
        return UserDetailsImpl.build(account);
    }
}
