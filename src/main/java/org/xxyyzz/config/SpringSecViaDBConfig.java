package org.xxyyzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.xxyyzz.provider.VerifyUserService;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName SpringSecViaDBConfig.java
 * @Description 通过重写方法实现更新AuthenticationManager，设置UserDetailsService
 *              及密码加密方式
 * @createTime 2022年11月18日 14:20:00
 */

//@Configuration
//@EnableGlobalAuthentication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecViaDBConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    VerifyUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder( new BCryptPasswordEncoder() );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage( "" );
    }
}
