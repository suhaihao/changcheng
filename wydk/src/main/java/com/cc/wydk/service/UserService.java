package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.User;
import com.cc.wydk.request.UserPageListRequest;
import com.cc.wydk.request.UserQueryRequest;
import com.cc.wydk.respond.UserRankingResponse;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 根据id获取用户
     * @param request
     * @return
     */
    User getById(UserQueryRequest request);

    /**
     *
     * @param request
     * @return
     */
    IPage<UserRankingResponse> getRankingUser(UserPageListRequest request);
}
