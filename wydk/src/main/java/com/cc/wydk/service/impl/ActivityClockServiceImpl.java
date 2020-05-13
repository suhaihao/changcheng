package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.mapper.ActivityClockMapper;
import com.cc.wydk.request.ActivityClockGetStatusRequest;
import com.cc.wydk.request.ActivityClockSetStatusRequest;
import com.cc.wydk.request.ActivityClockSignInRequest;
import com.cc.wydk.service.ActivityClockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    public Boolean getByActivityIdAndUserId(ActivityClockGetStatusRequest request) {
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", request.getUserId());
        queryWrapper.eq("sign_up", "1");
        return activityClockMapper.selectList(queryWrapper).size() > 0;
    }

    @Override
    public ActivityClock getByUserIdAndActivityIdAndTime(ActivityClockGetStatusRequest request) {
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", request.getUserId());
        queryWrapper.between("create_time", today_start, today_end);
        return activityClockMapper.selectOne(queryWrapper);
    }

    @Override
    public Boolean updateActivityClock(ActivityClockSetStatusRequest request) {
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", request.getUserId());
        queryWrapper.between("create_time", today_start, today_end);
        ActivityClock activityClock = activityClockMapper.selectOne(queryWrapper);
        if (null != activityClock) {
            if (request.getStatus().equals("1")) {
                activityClock.setStartTime(LocalDateTime.now());
                activityClock.setStatus(request.getStatus());
                activityClock.setUpdateTime(LocalDateTime.now());
                activityClockMapper.updateById(activityClock);
                return true;
            } else if (request.getStatus().equals("2")) {
                activityClock.setEndTime(LocalDateTime.now());
                activityClock.setStatus(request.getStatus());
                activityClock.setUpdateTime(LocalDateTime.now());
                Duration duration = Duration.between(activityClock.getStartTime(), activityClock.getEndTime());
                long time = duration.toMillis() / 1000;
                activityClock.setDuration(String.valueOf(time));
                activityClockMapper.updateById(activityClock);
                return true;
            }
        }
        return false;
    }
}
