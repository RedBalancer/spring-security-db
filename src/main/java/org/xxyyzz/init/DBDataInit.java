package org.xxyyzz.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.xxyyzz.dao.UserInfoDao;
import org.xxyyzz.entity.UserInfo;

import javax.annotation.PostConstruct;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName DBDataInit.java
 * @Description @TODO
 * @createTime 2022年11月17日 15:37:00
 */

//@Component
@Slf4j
public class DBDataInit {
    @Autowired
    UserInfoDao dao;

    public DBDataInit() {
      log.debug( "Execute constructor()" );
    }

    @PostConstruct
    public void initData() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        UserInfo user = new UserInfo();
        user.setUserName( "zhangsan" );
        user.setEnabled( 'Y' );
        user.setPassword( encoder.encode( "123456" ) );
        user.setRole( "USER" );

        dao.save( user );

        user = new UserInfo();
        user.setUserName( "lisi" );
        user.setEnabled( 'Y' );
        user.setPassword( encoder.encode( "123456" ) );
        user.setRole( "USER" );

        dao.save( user );

        user = new UserInfo();
        user.setUserName( "admin" );
        user.setEnabled( 'Y' );
        user.setPassword( encoder.encode( "admin11" ) );
        user.setRole( "ADMIN" );

        dao.save( user );

    }
}
