package org.xxyyzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.xxyyzz.provider.VerifyUserService;

import javax.annotation.PostConstruct;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName SecurityConfigInBeanWay.java
 * @Description 通过注入方式，直接修改容器中的AuthenticationManagerBuilder，达到使用用户名过滤用户的目的
 * @createTime 2022年11月18日 16:14:00
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SecurityConfigInBeanWay {
    @Autowired
    VerifyUserService userService;

    @Autowired
    AuthenticationManagerBuilder auth;

    @PostConstruct
    public void buildAuthentication() throws Exception {
        auth.userDetailsService(userService).passwordEncoder( new BCryptPasswordEncoder() ).and();
    }

//    @PostConstruct
//    public void buildAuthentication( AuthenticationManagerBuilder auth ) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder( new BCryptPasswordEncoder() ).and();
//    }
}
