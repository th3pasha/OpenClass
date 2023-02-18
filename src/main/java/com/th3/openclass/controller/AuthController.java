package com.th3.openclass.controller;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.dto.AccountDto;
import com.th3.openclass.dto.mapper.AccountMapper;
import com.th3.openclass.payload.JwtResponse;
import com.th3.openclass.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.th3.openclass.constants.ResourcePath.*;

@RestController
@CrossOrigin("*")
@RequestMapping(V1 + AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;


    @PostMapping(REGISTER)
    public ResponseEntity<AccountDto> register(@RequestBody final StudentCommand studentCommand){
        return ResponseEntity.ok(accountMapper.toDto(accountService.register(studentCommand)));
    }

    // TODO FOR UPDATE USER INFO
    @PostMapping(REGISTER + UPDATE)
    public ResponseEntity<AccountDto> regUpdate(@RequestBody final StudentCommand studentCommand){
        return ResponseEntity.ok(accountMapper.toDto(accountService.register(studentCommand)));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<JwtResponse> login(@RequestBody final StudentCommand studentCommand){
        return ResponseEntity.ok(accountService.login(studentCommand));
    }
    @GetMapping(PROFILE)
    public ResponseEntity<AccountDto> getCurrentProfile(){
        return ResponseEntity.ok(accountMapper.toDto(accountService.getProfile()));
    }
}
