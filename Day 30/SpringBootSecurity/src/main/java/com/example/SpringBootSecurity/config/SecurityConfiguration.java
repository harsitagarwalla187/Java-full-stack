package com.example.SpringBootSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        return security.csrf(custom -> custom.disable())
                .authorizeHttpRequests(req -> req.anyRequest()
                        .authenticated())
//              .authorizeHttpRequests(req -> req.requestMatchers("/about").permitAll());
//                .formLogin(Customizer.withDefaults())
                .formLogin(form -> form
                        .loginPage("/mylogin")
                        .defaultSuccessUrl(("/home")))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User
                .withUsername("admin")
                .password("{noop}admin@123") // to encode use {noop}
                .build();
        UserDetails user2 = User
                .withUsername("user")
                .password("{noop}user@123")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
