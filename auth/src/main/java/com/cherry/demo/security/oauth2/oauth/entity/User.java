package com.cherry.demo.security.oauth2.oauth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenyan
 * @date 5:32 PM
 */
public class User {

    private String username;

    private String password;

//    @ManyToMany(mappedBy="users")
//    private Set<Role> roles;

    private Set<Role> roles = new HashSet<>();

    private Set<GrantedAuthority> authorities = new HashSet<>();

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> userAuthotities = new HashSet<>();
        for(Role role : this.roles){
            for(Permission authority : role.getPermissions()){
                userAuthotities.add(new SimpleGrantedAuthority(authority.getCode()));
            }
        }

        return userAuthotities;
    }

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

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
