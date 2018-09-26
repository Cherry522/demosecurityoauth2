package com.cherry.demo.security.user.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author chenyan
 * @date 2:25 PM
 */
@Entity
@Table(name = "u_permission")
public class Permission {
    /**
     * 权限码
     */
    @Id
    private String code;

    public Permission() {
    }

    public Permission(String code) {
        this.code = code;
    }

    //权限和角色是多对多关系
    @ManyToMany(mappedBy="permissions")
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "u_role_permission",
//            joinColumns = @JoinColumn(name = "permission_code",referencedColumnName = "code"),
//            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
//    )
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
