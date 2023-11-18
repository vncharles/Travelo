package com.fit.Travelo.utils;

import com.fit.Travelo.exception.BadRequestException;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Authen {

    public static void check(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println("Username: " + username);
        if(username == null || username.equals("anonymousUser")){
            throw new BadRequestException(400, "User is not login");
        }
    }

    public static String getEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if(username == null || username.equals("anonymousUser")){
            throw new BadRequestException(400, "User is not login");
        }

        return username;
    }
}