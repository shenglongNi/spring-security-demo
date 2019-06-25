package com.nsl.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 1. 自定义login page
     * 2. Authorize Requests Mathcers
     * 3. Handling logouts
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/home")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                .formLogin()
//                    .loginPage("/customLogin")  //自定义login Page
                    .permitAll()
                    .and()
                .logout();

    }
}
