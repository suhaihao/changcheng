package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.entity.ActivityNotice;
import com.cc.wydk.mapper.ActivityClockMapper;
import com.cc.wydk.mapper.ActivityNoticeMapper;
import com.cc.wydk.request.*;
import com.cc.wydk.service.ActivityClockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ActivityClockServiceImpl extends ServiceImpl<ActivityClockMapper, ActivityClock> implements ActivityClockService {

    private final ActivityClockMapper activityClockMapper;

    private final ActivityNoticeMapper activityNoticeMapper;

    @Autowired
    public ActivityClockServiceImpl(ActivityClockMapper activityClockMapper, ActivityNoticeMapper activityNoticeMapper) {
        this.activityClockMapper = activityClockMapper;
        this.activityNoticeMapper = activityNoticeMapper;
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

    @Override
    public IPage<ActivityClock> getPageClockList(ActivityClockPageListRequest request) {
        Page<ActivityClock> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.orderByDesc("create_time");
        //mysql分组限制改人工去重处理
        IPage<ActivityClock> activityClockIPage = activityClockMapper.selectPage(page, queryWrapper);
        List<ActivityClock> collect = activityClockIPage.getRecords().stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ActivityClock::getUserId))), ArrayList::new));
        activityClockIPage.getRecords().clear();
        activityClockIPage.getRecords().addAll(collect);
        return activityClockIPage;
    }

    @Override
    public List<ActivityNotice> getPageNoticeList(ActivityNoticePageListRequest request) {
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", request.getUserId());
        queryWrapper.groupBy("activity_id");
        queryWrapper.select("activity_id");
        List<Integer> collect = activityClockMapper.selectList(queryWrapper).stream().map(ActivityClock::getActivityId).collect(Collectors.toList());
        return activityNoticeMapper.selectBatchIds(collect);
    }
}
