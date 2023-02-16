package org.xxyyzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxyyzz.dto.R;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName IPShow.java
 * @Description @TODO
 * @createTime 2023年02月10日 10:38:00
 */
@RestController
public class IPShow {

    @GetMapping( "/serverInfo" )
    public R getServerNodeNameAndIP() {
        String s = "Server: " + System.getenv( "HOST_NAME" );
//        try {
////            String ip = InetAddress.getLocalHost().getHostAddress();
////            String serverName = InetAddress.getLocalHost().getHostName();
//            s = "Server: " + System.getenv( "HOST_NAME" ) + ", IP: " + ip;
//        } catch (UnknownHostException e) {
//            s = e.toString();
//        }
        return R.ok( s );
    }
}
