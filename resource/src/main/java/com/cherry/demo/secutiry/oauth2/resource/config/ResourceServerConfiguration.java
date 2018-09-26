package com.cherry.demo.secutiry.oauth2.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * OAuth2配置
 * 配置资源服务器，控制哪些资源需要验证后可以访问，哪些资源不需要验证就能访问
 * @author chenyan
 * @date 下午2:49
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{


//    @Autowired
//    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

//    @Autowired
//    CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                //上面这行代码等同于：
                //@Autowired
                //    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
//                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/hello","/hello/*").permitAll()//定义"/hello/"这个资源不需要认证
                .anyRequest().authenticated()//定义任何请求都需要认证
                .and()
                .httpBasic();
    }


}
