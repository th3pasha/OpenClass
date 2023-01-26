package com.th3.openclass.repository;

import com.th3.openclass.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findAccountByStudentEmail(String email);
}
