package com.cherry.demo.security.user.controller;

import com.cherry.demo.security.user.entity.Permission;
import com.cherry.demo.security.user.entity.User;
import com.cherry.demo.security.user.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyan
 * @date 5:52 PM
 */
@Controller
public class UserController {
    @Autowired
    UserJpa userJpa;

    @Autowired
    PermissionJpa permissionJpa;
//
    @RequestMapping(path = "/user/{username}",method = RequestMethod.GET)
    @ResponseBody
    public User findByUsername(@PathVariable("username") String username){
        //正常这个地方应该从数据查，但是为了测试方便，就先写死了。
        return userJpa.findOne(username);
    }
//
//    @RequestMapping(path = "/role/{username}/{tenantId}",method = RequestMethod.GET)
//    @ResponseBody
//    public List<Role> findTenantRole(@PathVariable("username") String username, @PathVariable("tenantId") String tenantId){
//        //select role.* from u_tenant_user tenantUser,u_tenant_role tenantRole where tenantUser.username = username
//        // and tenantUser.tenant_id = tenantId
//        // and tenantRole.tenant_id = tenantId;
//
////        return tenantRoleJpa.findByTenantId(username,tenantId);
////        return tenantUserRoleJpa.findByTenantIdAndUsername(tenantId,username);
//        return tenantRoleRepository.findByTenantIdAndUsername(tenantId,username);
//    }

    @RequestMapping(path = "/permission/{username}",method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> findPermission(@PathVariable("username") String username){
        //select role.* from u_tenant_user tenantUser,u_tenant_role tenantRole where tenantUser.username = username
        // and tenantUser.tenant_id = tenantId
        // and tenantRole.tenant_id = tenantId;

//        return tenantRoleJpa.findByTenantId(username,tenantId);
//        return tenantUserRoleJpa.findByTenantIdAndUsername(tenantId,username);
        List<Permission> list = new ArrayList<>();
        if(username.equals("admin")){
            list.add(new Permission("vm_create"));
            list.add(new Permission("network_create"));
//        List<Permission> list = permissionJpa.findPermissionsByUsername(username);
        }
        list.add(new Permission("vm_list"));
        list.add(new Permission("network_list"));

//        if(username == "admin"){
//            list.add(permissionJpa.findOne("create_vm"));
//            list.add(permissionJpa.findOne("create_network"));
////        List<Permission> list = permissionJpa.findPermissionsByUsername(username);
//        }
//        list.add(permissionJpa.findOne("vm_list"));
//        list.add(permissionJpa.findOne("network_list"));
        return list;

    }

}
