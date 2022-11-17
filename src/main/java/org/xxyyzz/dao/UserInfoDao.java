package org.xxyyzz.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xxyyzz.entity.UserInfo;

import java.util.List;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName UserInfoDao.java
 * @Description @TODO
 * @createTime 2022年11月17日 14:21:00
 */
public interface UserInfoDao extends JpaRepository< UserInfo,Long > {
    /**
     * Get userInfo Entity by user name
     * 方法的名称要遵循 findBy + 属性名（首字母大写） + 查询条件(首字母大写 Is Equals)
     * @param userName
     * @return
     */
//    public UserInfo getUserByName( String userName );
    public UserInfo findByUserName( String userName );

}
