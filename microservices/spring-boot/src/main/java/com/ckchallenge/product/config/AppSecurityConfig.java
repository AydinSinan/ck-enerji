package com.ckchallenge.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/public/**").permitAll() // Public endpointlere izin ver
                                .antMatchers(HttpMethod.DELETE, "/api/deleteProduct/**").authenticated() // DELETE isteklerini kimlik doğrulamasına tabi tut

                                .anyRequest().authenticated() // Diğer tüm istekler için kimlik doğrulama gerektir
                )
                .httpBasic(withDefaults()); // Form tabanlı kimlik doğrulama kullan, varsayılan yapılandırma

        return http.build();
    }
}