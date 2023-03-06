package com.th3.openclass;

import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.enums.Role;
import com.th3.openclass.model.Account;
import com.th3.openclass.model.Student;
import com.th3.openclass.repository.AccountRepository;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OpenClassApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(OpenClassApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final StudentCommand studentCommand = new StudentCommand();
        studentCommand.setEmail("admin@ump.ac.ma");
        studentCommand.setPassword("123456789");
        final Student student = Student.create(studentCommand);
        studentRepository.save(student);

        final Account account = Account.create(student);
        account.setRole(Role.USER);
        accountRepository.save(account);
    }
}
