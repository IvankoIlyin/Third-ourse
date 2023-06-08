package com.example.lab2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails doctor1 = User.withDefaultPasswordEncoder()
                .username("doctor1")
                .password("doctor1")
                .roles("doctor")
                .build();
        UserDetails nurse1 = User.withDefaultPasswordEncoder()
                .username("nurse1")
                .password("nurse1")
                .roles("nurse")
                .build();

        return new InMemoryUserDetailsManager(doctor1, nurse1);
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/list").hasAnyRole("doctor","nurse");
                    auth.requestMatchers("/patient/*").hasAnyRole("doctor","nurse");
                    auth.requestMatchers("/patientUpdNur/*").hasRole("nurse");
                    auth.requestMatchers("/patientUpdDoc/*").hasRole("doctor");
                })
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .build();
    }


}