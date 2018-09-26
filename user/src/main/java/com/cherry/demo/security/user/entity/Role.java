package com.cherry.demo.security.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 租户的角色
 * @author chenyan
 * @date 5:57 PM
 */
@Entity
@Table(name = "u_role")
public class Role {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String name;

//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "u_user_role",
//            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
//            inverseJoinColumns = @JoinColumn(name = "username",referencedColumnName = "username"))
//    private Set<User> users = new HashSet<>();

    //CascadeType.ALL 级联所有实体状态转换
    //CascadeType.PERSIST 级联实体持久化操作。
    //CascadeType.MERGE 级联实体合并操作。
    //CascadeType.REMOVE 级联实体删除操作。
    //CascadeType.REFRESH 级联实体刷新操作。
    //CascadeType.DETACH 级联实体分离操作。
//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "u_role_permission",// 指定中间表名
//        joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),// 指定当前表在中间表的外键名称和外键所指向的当前表主键
//            inverseJoinColumns = @JoinColumn(name = "permission_code",referencedColumnName = "code")// 指定另一方在中间表的外键名称和外键所指向的主键
//    )
    @ManyToMany(targetEntity = Permission.class,fetch = FetchType.EAGER)
    private Set<Permission> permissions = new HashSet<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
