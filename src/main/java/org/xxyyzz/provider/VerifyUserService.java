package org.xxyyzz.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.xxyyzz.entity.UserInfo;
import org.xxyyzz.service.UserInfoService;

import java.util.ArrayList;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName VerifyUserService.java
 * @Description @TODO
 * @createTime 2022年11月18日 14:02:00
 */

@Component
public class VerifyUserService implements UserDetailsService {

    @Autowired
    @Qualifier( "User_Services")
    UserInfoService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = null;

        UserInfo userByName = userService.getUserByName(username);
        if( userByName == null ) {
            throw new UsernameNotFoundException( "User: " + username + " is not found" );
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority( "ROLE_" + userByName.getRole() );
        var roles = new ArrayList<GrantedAuthority>();
        roles.add( grantedAuthority );

        return new User( userByName.getUserName(), userByName.getPassword(), roles );
    }
}
