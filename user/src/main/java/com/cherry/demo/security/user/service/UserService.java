package com.cherry.demo.security.user.service;

import com.cherry.demo.security.user.entity.User;
import com.cherry.demo.security.user.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author chenyan
 * @date 9:53 AM
 */
@Service("userService")
public class UserService {
    private final UserJpa userJpa;

    @Autowired
    public UserService(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new StandardPasswordEncoder();
    }

    public User save(User user){
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        return userJpa.save(user);
    }
}
