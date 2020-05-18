package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.User;
import com.cc.wydk.mapper.UserMapper;
import com.cc.wydk.request.UserPageListRequest;
import com.cc.wydk.request.UserQueryRequest;
import com.cc.wydk.respond.UserRankingResponse;
import com.cc.wydk.respond.UserResPonse;
import com.cc.wydk.service.ActivityClockService;
import com.cc.wydk.service.UserService;
import com.cc.wydk.service.VolunteerOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    private final UserMapper userMapper;

    private final VolunteerOrderService volunteerOrderService;

    private final ActivityClockService activityClockService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, VolunteerOrderService volunteerOrderService, ActivityClockService activityClockService) {
        this.userMapper = userMapper;
        this.volunteerOrderService = volunteerOrderService;
        this.activityClockService = activityClockService;
    }

    @Override
    public UserResPonse getById(UserQueryRequest request) {
        User user = userMapper.selectById(request.getId());
        if (null != user) {
            UserResPonse userResPonse = new UserResPonse();
            BeanUtils.copyProperties(user, userResPonse);
            Integer countOrder = volunteerOrderService.getCount(request.getId());
            userResPonse.setOrderCount(countOrder);
            Integer countClock = activityClockService.getCount(request.getId());
            userResPonse.setActivitySignCount(countClock);
            return userResPonse;
        }
        return null;
    }

    @Override
    public IPage<UserRankingResponse> getRankingUser(UserPageListRequest request) {
        Page<UserRankingResponse> page = new Page<>(request.getPageIndex(), request.getPageSize());
        return userMapper.getRankingList(page);
    }
}
