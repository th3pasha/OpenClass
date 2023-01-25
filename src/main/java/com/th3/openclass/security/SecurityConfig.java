package com.th3.openclass.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception
    {
        http.oauth2Login().defaultSuccessUrl("/home", true);
        return http.build();
    }
}
