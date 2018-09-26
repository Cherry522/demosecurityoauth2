package com.cherry.demo.security.oauth2.oauth.entity;

import java.util.List;

/**
 * @author chenyan
 * @date 2:25 PM
 */
public class Permission{
    /**
     * 权限码
     */
    private String code;

    public Permission() {
    }

    public Permission(String code) {
        this.code = code;
    }

    private List<Role> roles;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
