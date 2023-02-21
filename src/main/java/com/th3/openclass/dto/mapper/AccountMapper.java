package com.th3.openclass.dto.mapper;


import com.th3.openclass.command.EmailCommand;
import com.th3.openclass.dto.AccountDto;
import com.th3.openclass.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(Account account);
    EmailCommand toDto(EmailCommand emailCommand);
}
