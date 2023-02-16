package org.xxyyzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Arrays;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName SpringSecurityViaDB.java
 * @Description @TODO
 * @createTime 2022年11月17日 14:50:00
 */
@SpringBootApplication //( exclude = {SecurityAutoConfiguration.class} )
//@EnableGlobalMethodSecurity(prePostEnabled=false)
public class SpringSecurityViaDB {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringSecurityViaDB.class);
//        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
//            System.out.println( ":->" + beanDefinitionName );
//        }
    }
}
