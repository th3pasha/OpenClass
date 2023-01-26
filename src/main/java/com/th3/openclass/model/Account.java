package com.th3.openclass.model;


import com.th3.openclass.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ACCOUNTS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter

public class Account extends BaseEntity{

    @OneToOne
    private Student student;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private Role role;

    public static Account create(final Student student){
        final Account account = new Account();
        account.student = student;
        account.role = Role.ADMIN;

        return account;
    }
}
