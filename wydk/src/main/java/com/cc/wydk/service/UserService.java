package com.cc.wydk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.User;
import com.cc.wydk.request.UserQueryRequest;

public interface UserService extends IService<User> {

    User getById(UserQueryRequest request);
}
