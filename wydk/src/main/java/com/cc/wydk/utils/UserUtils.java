package com.cc.wydk.utils;


import com.cc.wydk.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static Integer getUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (null != user) {
            return user.getId();
        }
        return null;
    }

    public static User getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (null != user) {
            return user;
        }
        return null;
    }
}
