package com.cherry.demo.security.user.repository;

import com.cherry.demo.security.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenyan
 * @date 6:09 PM
 */
public interface RoleJpa  extends JpaRepository<Role,String> {
}
