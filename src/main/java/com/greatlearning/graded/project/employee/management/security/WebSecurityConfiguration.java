package com.greatlearning.graded.project.employee.management.security;

import com.greatlearning.graded.project.employee.management.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/api/employees/save", "/api/employees/delete").hasAuthority("ADMIN");
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

    }
}
