package org.xxyyzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.xxyyzz.provider.VerifyUserService;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName SpringSecViaDBConfig.java
 * @Description @TODO
 * @createTime 2022年11月18日 14:20:00
 */

@Configuration
//@EnableGlobalAuthentication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecViaDBConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    VerifyUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder( new BCryptPasswordEncoder() );
    }
}
