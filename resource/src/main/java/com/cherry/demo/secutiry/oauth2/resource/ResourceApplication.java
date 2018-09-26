package com.cherry.demo.secutiry.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author chenyan
 * @date 4:10 PM
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)//启用spring security全局方法
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class,args);
    }
}
