package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.mapper.ActivityClockMapper;
import com.cc.wydk.request.ActivityClockGetStatusRequest;
import com.cc.wydk.request.ActivityClockSignInRequest;
import com.cc.wydk.service.ActivityClockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;

@Service
public class ActivityClockServiceImpl extends ServiceImpl<ActivityClockMapper, ActivityClock> implements ActivityClockService {

    private final ActivityClockMapper activityClockMapper;

    @Autowired
    public ActivityClockServiceImpl(ActivityClockMapper activityClockMapper) {
        this.activityClockMapper = activityClockMapper;
    }

    @Override
    @Transient
    public Boolean saveActivityClock(ActivityClockSignInRequest request) {
        ActivityClock activityClock = new ActivityClock();
        BeanUtils.copyProperties(request, activityClock);
        activityClock.setStartTime(LocalDateTime.now());
        activityClock.setEndTime(LocalDateTime.now());
        activityClock.setCreateTime(LocalDateTime.now());
        activityClock.setUpdateTime(LocalDateTime.now());
        return activityClockMapper.insert(activityClock) > 0;
    }

    @Override
    public ActivityClock getByUserIdAndActivityId(ActivityClockGetStatusRequest request) {
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", request.getUserId());
        return activityClockMapper.selectOne(queryWrapper);
    }
}
