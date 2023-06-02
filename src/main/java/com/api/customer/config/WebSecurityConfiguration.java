package com.api.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .and()
                .build();
    }
    
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http.csrf().disable()
    // .authorizeHttpRequests()
    // .requestMatchers("/registration/**", "/login/**").permitAll()
    // .anyRequest().authenticated()
    // .and()
    // .formLogin().loginPage("/login").successHandler(successHandler)
    // .and().csrf().disable()
    // .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
    // .and().oauth2Login().loginPage("/login").successHandler(successHandler);
    // return http.build();
    // }

    @Autowired
    AuthenticationSuccessHandler successHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
