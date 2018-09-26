package com.cherry.demo.security.user.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenyan
 * @date 5:32 PM
 */
@Entity
@Table(name = "u_user")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    private String password;

//    @ManyToMany(mappedBy="users")
    @ManyToMany(targetEntity = Role.class,fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

//    @Transient
//    private Set<GrantedAuthority> authorities = new HashSet<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
