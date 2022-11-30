package com.kma.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("viewerA")
                .password("psw0011")
                .roles("VIEWER")
                .and()
                .withUser("adminB")
                .password("psw0adm")
                .roles("ADMIN");
    }


    /**
     *
     * PLEASE FOR THE LOVE OF GOD DON'T TOUCH THIS
     *
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().
                antMatchers("/admin/**").hasRole("ADMIN").
                antMatchers("/viewer/**").hasRole("VIEWER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
                .and().logout()
                .logoutSuccessUrl("/").permitAll();

    }
}