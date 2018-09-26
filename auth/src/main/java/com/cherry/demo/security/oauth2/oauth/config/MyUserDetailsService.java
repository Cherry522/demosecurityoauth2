package com.cherry.demo.security.oauth2.oauth.config;

import com.alibaba.fastjson.JSON;
import com.cherry.demo.security.oauth2.oauth.entity.Permission;
import com.cherry.demo.security.oauth2.oauth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author chenyan
 * @date 5:08 PM
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    public MyUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库读取用户
        String lowercaseUsername = username.toLowerCase();

        String url = "http://127.0.0.1:8112/user/"+username;
//        ResponseEntity<User> responseUser = restTemplate.getForEntity(url,User.class);
//        if(null != responseUser){
//            User user = responseUser.getBody();
//        }
        User user = restTemplate.getForEntity(url,User.class).getBody();
        if(null == user){
//            throw new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the database");
            throw new UsernameNotFoundException("用户" + lowercaseUsername + "不存在!");
        }

        //设置对应的角色后返回SpringSecurity内置的User对象实例
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        String permissionUrl = "http://127.0.0.1:8112/permission/"+username;
        String permissionsJson = restTemplate.getForEntity(permissionUrl,String.class).getBody();
        if(null != permissionsJson && permissionsJson.length() > 0){
            List<Permission> permissions = JSON.parseArray(permissionsJson,Permission.class);
            for (Permission authority : permissions){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getCode());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }
}
