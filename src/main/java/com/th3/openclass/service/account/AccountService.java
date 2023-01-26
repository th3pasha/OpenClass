package com.th3.openclass.service.account;

import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.model.Account;
import com.th3.openclass.payload.JwtResponse;

public interface AccountService {
    Account register(StudentCommand studentCommand);
    JwtResponse login(StudentCommand studentCommand);
    Account getProfile();
}
