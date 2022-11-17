package org.xxyyzz.service;

import org.springframework.stereotype.Service;
import org.xxyyzz.entity.UserInfo;

@Service
public interface UserInfoService {

    UserInfo getUserByName(String userName );
}
