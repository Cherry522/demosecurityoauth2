package com.cherry.demo.security.user.repository;

import com.cherry.demo.security.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chenyan
 * Date: 2018/8/2
 * Time: 5:50 PM
 * Describe:
 */
public interface UserJpa extends JpaRepository<User,String> {

    /**
     * Containing 模糊查询
     * @param username
     * @return
     */
    List<User> findByUsernameContaining(String username);
}
