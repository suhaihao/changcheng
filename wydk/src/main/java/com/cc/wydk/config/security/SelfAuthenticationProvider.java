package com.cc.wydk.config.security;

import com.alibaba.druid.util.StringUtils;
import com.cc.wydk.entity.AdminUser;
import com.cc.wydk.entity.User;
import com.cc.wydk.enumDate.ExceptionEnum;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.service.AdminUserService;
import com.cc.wydk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SelfAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;
    @Autowired
    AdminUserService adminUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String ps = encoder.encode(password);
        if (StringUtils.isNumber(username) && username.length() == 11) {
            User user = userService.loginByUserName(username);
            if (null == user) {
                throw new BusinessInterfaceException(ExceptionEnum.FAILURELOGIN.getCode(), ExceptionEnum.FAILURELOGIN.getMsg());
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                user.setPassword("123");
            }
            if (!encoder.encode(user.getPassword()).equals(ps)) {
                throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
            }
            return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        } else {
            AdminUser byUserName = adminUserService.getByUserName(username);
            if (null == byUserName) {
                throw new BusinessInterfaceException(ExceptionEnum.FAILURELOGIN.getCode(), ExceptionEnum.FAILURELOGIN.getMsg());
            }
            if (!encoder.encode(byUserName.getPassword()).equals(ps)) {
                throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
            }
            return new UsernamePasswordAuthenticationToken(username, password, null);
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
