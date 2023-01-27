package com.th3.openclass.controller;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.dto.AccountDto;
import com.th3.openclass.dto.mapper.AccountMapper;
import com.th3.openclass.payload.JwtResponse;
import com.th3.openclass.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.th3.openclass.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;



    @PostMapping(REGISTER)
    public ResponseEntity<AccountDto> register(@RequestBody final StudentCommand studentCommand){
        return ResponseEntity.ok(accountMapper.toDto(accountService.register(studentCommand)));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<JwtResponse> login(@RequestBody final StudentCommand studentCommand){
        return ResponseEntity.ok(accountService.login(studentCommand));
    }
}
