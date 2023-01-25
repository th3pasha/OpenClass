package com.th3.openclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class OpenClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenClassApplication.class, args);
    }

}
