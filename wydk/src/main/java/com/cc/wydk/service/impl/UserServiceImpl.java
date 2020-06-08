package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.hebeiwanteng.com
 *
 * @author 苏海
 * Package com.hebeiwanteng.ipc_shopping_server.response.advert
 * ClassName:AdvertPlanPageEntityResponse
 * Description:
 * Date 上午11:02 2020/6/8
 * Modify By :
 * Copyright: 2018 www.hebeiwanteng.com Inc. All rights reserved.
 * 注意：本内容仅限于河北万腾科技有限公司内部传阅，禁止外泄以及用于其他的商业目的.
 */
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", s);
        User user = userMapper.selectOne(queryWrapper);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String ps = encoder.encode("123");
        user.setPassword(ps);
        return user;
    }

    @Override
    public User loginByUserName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", userName);
        return userMapper.selectOne(queryWrapper);

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
