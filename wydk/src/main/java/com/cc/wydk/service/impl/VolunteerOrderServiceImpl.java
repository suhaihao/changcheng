package com.cc.wydk.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.mapper.UserMapper;
import com.cc.wydk.mapper.VolunteerOrderMapper;
import com.cc.wydk.request.VolunteerPageListRequest;
import com.cc.wydk.service.VolunteerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerOrderServiceImpl extends ServiceImpl<VolunteerOrderMapper, VolunteerOrder> implements VolunteerOrderService {

    private final VolunteerOrderMapper volunteerOrderMapper;

    private final UserMapper userMapper;

    @Autowired
    public VolunteerOrderServiceImpl(VolunteerOrderMapper volunteerOrderMapper, UserMapper userMapper) {
        this.volunteerOrderMapper = volunteerOrderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public IPage<VolunteerOrder> getByPageList(VolunteerPageListRequest request) {
        Page<VolunteerOrder> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<VolunteerOrder> queryWrapperUser = new QueryWrapper();
        if (!StringUtils.isEmpty(request.getType())) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.orderByDesc("create_time");
        return volunteerOrderMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public IPage<User> getByPageUserList(VolunteerPageListRequest request) {
        QueryWrapper<VolunteerOrder> queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(request.getType())) {
            queryWrapper.eq("type", request.getType());
        }
        queryWrapper.select("user_id");
        queryWrapper.groupBy("user_id");
        List<Integer> collect = volunteerOrderMapper.selectList(queryWrapper).stream().map(VolunteerOrder::getUserId).collect(Collectors.toList());
        Page<User> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<User> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.in("id", collect);
        return userMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public Integer getCount(Integer userId) {
        QueryWrapper<VolunteerOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return volunteerOrderMapper.selectCount(queryWrapper);
    }
}
