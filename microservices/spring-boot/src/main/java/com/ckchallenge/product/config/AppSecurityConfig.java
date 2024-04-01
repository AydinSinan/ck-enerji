package com.ckchallenge.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        // Hiçbir endpoint için doğrulama istenmez
        http.authorizeHttpRequests(c -> c.anyRequest().permitAll());

        // Her endpoint için doğrulama istenir
        // http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        return http.build();
    }

}