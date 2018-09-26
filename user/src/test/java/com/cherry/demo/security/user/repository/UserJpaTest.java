package com.cherry.demo.security.user.repository;

import com.cherry.demo.security.user.entity.*;
import com.cherry.demo.security.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenyan
 * @date 9:36 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Transactional
public class UserJpaTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionJpa permissionJpa;

    @Autowired
    private RoleJpa roleJpa;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new StandardPasswordEncoder();
    }

//    @Test
//    public void initData(){
//        Permission vmListPer = new Permission("vm_list");
//        Permission vmCreatePer = new Permission("vm_create");
//        Permission networkListPer = new Permission("network_list");
//        Permission networkCreatePer = new Permission("network_create");
//
////        vmListPer = permissionJpa.save(vmListPer);
////        vmCreatePer = permissionJpa.save(vmCreatePer);
////        networkListPer = permissionJpa.save(networkListPer);
////        networkCreatePer = permissionJpa.save(networkCreatePer);
//
//        Role adminRole = new Role("admin");
//        Role userRole = new Role("user");
//
//        //角色-权限关系
//        adminRole.getPermissions().addAll(Arrays.asList(vmListPer,vmCreatePer,networkListPer,networkCreatePer));
//        userRole.getPermissions().addAll(Arrays.asList(vmListPer,networkListPer));
//
//        User adminUser = new User("admin", "admin"); //拥有管理员、普通租户管理和成员的角色
//        User chenyanUser = new User("chenyan", "123456"); //拥有普通租户管理和成员的角色
////        adminUser = userService.save(adminUser);
////        chenyanUser = userService.save(chenyanUser);
//
//        //角色-用户关系
//        adminUser.getRoles().addAll(Arrays.asList(adminRole,userRole));
//        chenyanUser.getRoles().addAll(Arrays.asList(userRole));
//
//        roleJpa.save(Arrays.asList(adminRole,userRole));
//    }

//    @Test
//    public void initData(){
//        Permission vmListPer = new Permission("vm_list");
//        Permission vmCreatePer = new Permission("vm_create");
//        Permission networkListPer = new Permission("network_list");
//        Permission networkCreatePer = new Permission("network_create");
//
////        vmListPer = permissionJpa.save(vmListPer);
////        vmCreatePer = permissionJpa.save(vmCreatePer);
////        networkListPer = permissionJpa.save(networkListPer);
////        networkCreatePer = permissionJpa.save(networkCreatePer);
//
//        User adminUser = new User("admin", "admin"); //拥有管理员、普通租户管理和成员的角色
//        User chenyanUser = new User("chenyan", "123456"); //拥有普通租户管理和成员的角色
////        adminUser = userService.save(adminUser);
////        chenyanUser = userService.save(chenyanUser);
//
//        Role adminRole = new Role("admin");
//        Role userRole = new Role("user");
//
//        //角色-权限关系
//        adminRole.getPermissions().addAll(Arrays.asList(vmListPer,vmCreatePer,networkListPer,networkCreatePer));
//        userRole.getPermissions().addAll(Arrays.asList(vmListPer,networkListPer));
//
//        //角色-用户关系
//        adminRole.getUsers().addAll(Arrays.asList(adminUser));
//        userRole.getUsers().addAll(Arrays.asList(chenyanUser));
//        roleJpa.save(Arrays.asList(adminRole,userRole));
//    }

//    @Test
//    public void findPermissionByUsername() {
//        String username = "chenyan";
//        List<Permission> list = permissionJpa.findPermissionsByUsername(username);
////        System.out.println(JSON.toJSON(list));
////        permissionJpa.findAll();
//    }
//    @Test
//    public void findPermissionByRoleId() {
////        String roleId = "8a85877565121ae00165121ae9080000";
////        List<Permission> list = permissionJpa.findPermissionsByRoleId(roleId);
////        System.out.println(JSON.toJSON(list));
////        permissionJpa.findAll();
//    }
//
    @Test
    public void addUser() {
        User user = new User("admin", "admin"); //拥有管理员、普通租户管理和成员的角色
        userService.save(user);

        user = new User("chenyan", "123456"); //拥有普通租户管理和成员的角色
        userService.save(user);
    }
//
//
//    @Test
//    public void addRole() {
//
//
//        Role adminRole = new Role("admin");
//        adminRole = roleJpa.save(adminRole);
//        adminRole.getUsers().addAll(Arrays.asList())
//
//
//        Role userRole = new Role("user");
//        userRole = roleJpa.save(userRole);
//
//        user.getRoles().addAll(Arrays.asList(adminRole,userRole));
//    }
//
//
//    @Test
//    public void userAddRole() {
//        user
//        User user = new User("admin", "admin",CollectionUtils.arrayToList(new Role[]{adminRole,userRole})); //拥有管理员、普通租户管理和成员的角色
//        userService.save(user);
//
//        user = new User("chenyan", "123456",CollectionUtils.arrayToList(new Role[]{userRole})); //拥有普通租户管理和成员的角色
//        userService.save(user);
//    }



//    @Test
//    public void addTenantAndUserAndRole(){
//        Tenant tenant = new Tenant("管理员租户");
//        tenant = tenantJpa.save(tenant);
//        String adminTenantId = tenant.getId();
//
//        TenantUser tenantUser = new TenantUser(adminTenantId,"admin");
//        tenantUserJpa.save(tenantUser);
//
//        tenant = new Tenant("普通租户1");
//        tenant = tenantJpa.save(tenant);
//        String tenantId1 = tenant.getId();
//
//        tenantUser = new TenantUser(tenantId1,"admin");
//        tenantUserJpa.save(tenantUser);
//
//        tenantUser = new TenantUser(tenantId1,"chenyan");
//        tenantUserJpa.save(tenantUser);
//
//        tenantUser = new TenantUser(tenantId1,"zhangsan");
//        tenantUserJpa.save(tenantUser);
//
//        tenantUser = new TenantUser(tenantId1,"lisi");
//        tenantUserJpa.save(tenantUser);
//
//
//
//        Role tenantRole = new Role(adminTenantId,"管理员角色");
//        tenantRole = tenantRoleJpa.save(tenantRole);
//        String adminRoleId = tenantRole.getId();
//
//        TenantUserRole tenantUserRole = new TenantUserRole(adminTenantId,"admin",adminRoleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//
//        tenantRole = new Role(adminTenantId,"普通租户管理员角色");
//        tenantRole = tenantRoleJpa.save(tenantRole);
//        String roleId = tenantRole.getId();
//
//        tenantUserRole = new TenantUserRole(adminTenantId,"admin",roleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//
//        tenantUserRole = new TenantUserRole(tenantId1,"chenyan",roleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//
//        tenantRole = new Role(adminTenantId,"租户成员角色");
//        tenantRole = tenantRoleJpa.save(tenantRole);
//        String memberRoleId = tenantRole.getId();
//
//        tenantUserRole = new TenantUserRole(adminTenantId,"admin",memberRoleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//        tenantUserRole = new TenantUserRole(adminTenantId,"chenyan",memberRoleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//        tenantUserRole = new TenantUserRole(adminTenantId,"zhangsan",memberRoleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//        tenantUserRole = new TenantUserRole(adminTenantId,"lisi",memberRoleId);
//        tenantUserRoleJpa.save(tenantUserRole);
//    }
}