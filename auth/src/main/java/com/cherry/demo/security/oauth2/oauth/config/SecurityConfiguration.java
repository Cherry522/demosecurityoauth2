package com.cherry.demo.security.oauth2.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author chenyan
 * @date 上午11:22
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Qualifier("enableGlobalAuthenticationAutowiredConfigurer")
//    @Autowired
//    private GlobalAuthenticationConfigurerAdapter enableGlobalAuthenticationAutowiredConfigurer;

    /**
     * 设置匹配用户密码时的规则
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new StandardPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }

    //配置全局设置
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).//设置userDetailsService
                passwordEncoder(passwordEncoder());//设置密码规则
    }

    /**
     * 不定义没有password grant_type
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


//    /**
//     * 排除/hello路径拦截
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/hello");
//    }
//
//    /**
//     * 开启全局方法拦截
//     */
//    @EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true)
//    public static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration{
//        @Override
//        protected MethodSecurityExpressionHandler createExpressionHandler() {
//            return super.createExpressionHandler();
//        }
//    }
}
