package org.xxyyzz.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxyyzz.dao.UserInfoDao;
import org.xxyyzz.entity.UserInfo;
import org.xxyyzz.service.UserInfoService;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName UserInfoServiceImpl.java
 * @Description @TODO
 * @createTime 2022年11月17日 14:29:00
 */

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserByName(String userName) {
        if( userName == null || userName.length() == 0 ) {
            log.error( "Input User Name is Empty" );
            return null;
        }
//        UserInfo userInfo = userInfoDao.getUserByName( userName );
        var userInfo = userInfoDao.findByUserName( userName );
        if( userInfo != null ) {
            return userInfo;
        } else {
            log.error( "User: " + userName + " is not found." );
        }
        return null;
    }
}
