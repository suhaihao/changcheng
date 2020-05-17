package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.User;
import com.cc.wydk.mapper.UserMapper;
import com.cc.wydk.request.UserQueryRequest;
import com.cc.wydk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getById(UserQueryRequest request) {
        return userMapper.selectById(request.getId());
    }
}
