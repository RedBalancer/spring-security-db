package org.xxyyzz.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxyyzz.service.UserInfoService;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName WebController.java
 * @Description @TODO
 * @createTime 2022年11月18日 11:00:00
 */

@RestController
public class WebController {

    @Autowired
    @Qualifier( "User_Services" )
    UserInfoService service;

    @RequestMapping("/user/{name}")
    @PreAuthorize( "hasRole( \"ADMIN\" )")
    String getUserInfo( @PathVariable( "name" ) String userName) {
        return service.getUserByName( userName ).toString();
    }
}
