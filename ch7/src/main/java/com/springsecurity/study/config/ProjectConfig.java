package com.springsecurity.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();

//        var user1 = User.withUsername("john")
//                .password("12345")
//                .authorities("READ")
//                .build();
//
//        var user2 = User.withUsername("jane")
//                .password("12345")
//                .authorities("WRITE")
//                .build();

//        var user1 = User.withUsername("john")
//                        .password("12345")
//                                .authorities("read")
//                                        .build();
//
//        var user2 = User.withUsername("jane")
//                        .password("12345")
//                                .authorities("read", "write", "delete")
//                                        .build();

//        var user1 = User.withUsername("john")
//                        .password("12345")
//                                .authorities("ROLE_ADMIN")
//                                        .build();
//
//        var user2 = User.withUsername("jane")
//                        .password("12345")
//                                .authorities("ROLE_MANAGER")
//                                        .build();

        var user1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("jane")
                .password("12345")
                .roles("MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

//        http.authorizeRequests()
//                .anyRequest().hasAnyAuthority("WRITE", "READ");

//        String expression = "hasAuthority('read') and !hasAuthority('delete')";
//
//        http.authorizeRequests()
//                .anyRequest()
//                .access(expression);

//        http.authorizeRequests()
//                .anyRequest().hasRole("ADMIN");

        http.authorizeRequests()
                .anyRequest().denyAll();
    }
}
