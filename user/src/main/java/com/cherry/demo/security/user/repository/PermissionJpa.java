package com.cherry.demo.security.user.repository;

import com.cherry.demo.security.user.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenyan
 * @date 5:58 PM
 */
public interface PermissionJpa extends JpaRepository<Permission,String> {
//
////    @Query(value = "SELECT permission FROM Permission permission WHERE permission.code in( SELECT rp.permissionCode FROM RolePermission rp WHERE rp.roleId in( SELECT ur.roleId FROM UserRole ur WHERE username = :username))")
//    @Query(value = "SELECT permission FROM Permission permission WHERE permission.code in( SELECT rp.permissionCode FROM RolePermission rp WHERE rp.roleId in( SELECT ur.roleId FROM UserRole ur WHERE username = :username))")
////    @Query(value = "SELECT permission FROM Permission permission WHERE permission.code in( SELECT rp.permissionCode FROM u_role_permission rp WHERE rp.role_id in( SELECT ur.role_id FROM user_role ur WHERE username = :username))")
//    List<Permission> findPermissionsByUsername(@Param("username") String username);
//
//    List<Permission> findByCode(String code);

//    @Query(value = "SELECT permission FROM Permission permission WHERE permission.roles.id = :roleId")
//    List<Permission> findPermissionsByRoleId(@Param("roleId") String roleId);
}
