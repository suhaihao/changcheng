package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ActivityMessage;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.mapper.ActivityMessageMapper;
import com.cc.wydk.mapper.VolunteerTeamMapper;
import com.cc.wydk.request.ActivityMessagePageListRequest;
import com.cc.wydk.request.VolunteerTeamPageListRequest;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.ActivityMessageService;
import com.cc.wydk.service.VolunteerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityMessageServiceImpl extends ServiceImpl<ActivityMessageMapper, ActivityMessage> implements ActivityMessageService {

    private final ActivityMessageMapper activityMessageMapper;


    @Autowired
    public ActivityMessageServiceImpl(ActivityMessageMapper activityMessageMapper) {
        this.activityMessageMapper = activityMessageMapper;
    }


    @Override
    public IPage<ActivityMessage> getPageList(ActivityMessagePageListRequest request) {
        Page<ActivityMessage> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ActivityMessage> queryWrapper = new QueryWrapper<>();
        if (null != request.getActivityId()) {
            queryWrapper.eq("activity_id", request.getActivityId());
        }
        queryWrapper.orderByDesc("create_Time");
        return activityMessageMapper.selectPage(page, queryWrapper);
    }
}
