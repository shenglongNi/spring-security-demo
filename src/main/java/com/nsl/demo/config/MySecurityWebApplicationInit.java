package com.nsl.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


/**
 * 在非 spring工程中， 使用这种方式配置 httpSecurity
 */
public class MySecurityWebApplicationInit extends AbstractSecurityWebApplicationInitializer {

    /*laod securityConfig
     *
     */
    public MySecurityWebApplicationInit() {
        super(SecurityConfig.class);
    }
}
