package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.entity.ActivityNotice;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.mapper.ActivityClockMapper;
import com.cc.wydk.mapper.ActivityNoticeMapper;
import com.cc.wydk.mapper.UserMapper;
import com.cc.wydk.mapper.VolunteerTeamMapper;
import com.cc.wydk.request.*;
import com.cc.wydk.response.ActivityClockResponse;
import com.cc.wydk.service.ActivityClockService;
import com.cc.wydk.utils.LatLonUtil;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityClockServiceImpl extends ServiceImpl<ActivityClockMapper, ActivityClock> implements ActivityClockService {

    private final ActivityClockMapper activityClockMapper;

    private final ActivityNoticeMapper activityNoticeMapper;

    private final UserMapper userMapper;

    private final VolunteerTeamMapper volunteerTeamMapper;

    @Autowired
    public ActivityClockServiceImpl(ActivityClockMapper activityClockMapper, ActivityNoticeMapper activityNoticeMapper, UserMapper userMapper, VolunteerTeamMapper volunteerTeamMapper) {
        this.activityClockMapper = activityClockMapper;
        this.activityNoticeMapper = activityNoticeMapper;
        this.userMapper = userMapper;
        this.volunteerTeamMapper = volunteerTeamMapper;
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
        activityClock.setUserId(UserUtils.getUserId());
        return activityClockMapper.insert(activityClock) > 0;
    }

    @Override
    public Boolean getByActivityIdAndUserId(ActivityClockGetStatusRequest request) {
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", UserUtils.getUserId());
        queryWrapper.eq("sign_up", "1");
        return activityClockMapper.selectList(queryWrapper).size() > 0;
    }

    @Override
    public ActivityClock getByUserIdAndActivityIdAndTime(ActivityClockGetStatusRequest request) {
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", UserUtils.getUserId());
        queryWrapper.between("create_time", today_start, today_end);
        ActivityClock activityClock = activityClockMapper.selectOne(queryWrapper);
        return activityClock;
    }

    @Override
    @Transient
    public Boolean updateActivityClock(ActivityClockSetStatusRequest request) {
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.eq("user_id", UserUtils.getUserId());
        queryWrapper.between("create_time", today_start, today_end);
        ActivityClock activityClock = activityClockMapper.selectOne(queryWrapper);
        if (null != activityClock) {
            ActivityNotice activityNotice = activityNoticeMapper.selectById(request.getActivityId());
            if (null != activityClock) {
                if (request.getStatus().equals("1")) {
                    double v = LatLonUtil.GetDistance(activityNotice.getLongitude(), activityNotice.getLatitude(), request.getLongitude(), request.getLatitude());
                    if (v > activityNotice.getRadius()) {
                        throw new BusinessInterfaceException("未在打卡范围内");
                    }
                    if (activityNotice.getStartTime().isAfter(LocalDateTime.now())) {
                        throw new BusinessInterfaceException("活动未开始");
                    }
                    activityClock.setLongitude(request.getLongitude());
                    activityClock.setLatitude(request.getLatitude());
                    activityClock.setStartTime(LocalDateTime.now());
                    activityClock.setStatus(request.getStatus());
                    activityClock.setUpdateTime(LocalDateTime.now());
                    activityClockMapper.updateById(activityClock);
                    return true;
                } else if (request.getStatus().equals("2")) {
                    double v = LatLonUtil.GetDistance(activityNotice.getLongitude(), activityNotice.getLatitude(), request.getLongitude(), request.getLatitude());
                    if (v > activityNotice.getRadius()) {
                        throw new BusinessInterfaceException("未在打卡范围内");
                    }
                    if (activityNotice.getEndTime().isBefore(LocalDateTime.now())) {
                        throw new BusinessInterfaceException("活动已结束");
                    }
                    activityClock.setLongitude(request.getLongitude());
                    activityClock.setLatitude(request.getLatitude());
                    activityClock.setEndTime(LocalDateTime.now());
                    activityClock.setStatus(request.getStatus());
                    activityClock.setUpdateTime(LocalDateTime.now());
                    Duration duration = Duration.between(activityClock.getStartTime(), activityClock.getEndTime());
                    long time = duration.toMillis() / 1000;
                    activityClock.setDuration(String.valueOf(time));
                    activityClockMapper.updateById(activityClock);
                    //更新用户积分
                    User user = userMapper.selectById(UserUtils.getUserId());
                    if (null != user) {
                        user.setIntegral(user.getIntegral() + (int) time / 60 / 60 + 1);
                        user.setService(user.getService() + (int) time / 60 / 60 + 1);
                    }
                    userMapper.updateById(user);
                    //更新团队积分
                    if (!StringUtils.isEmpty(user.getTeam())) {
                        VolunteerTeam volunteerTeam = volunteerTeamMapper.selectById(user.getTeam());
                        if (null != volunteerTeam) {
                            volunteerTeam.setServiceDuration(volunteerTeam.getServiceDuration() + (int) time);
                        }
                        volunteerTeam.setNumberOfServices(volunteerTeam.getNumberOfServices() + 1);
                        volunteerTeamMapper.updateById(volunteerTeam);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public IPage<User> getPageClockList(ActivityClockPageListRequest request) {

        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_id", request.getActivityId());
        queryWrapper.groupBy("user_id");
        queryWrapper.select("user_id");
        List<Integer> collect = activityClockMapper.selectList(queryWrapper).stream().map(ActivityClock::getUserId).collect(Collectors.toList());
        Page<User> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<User> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.in("id", collect);
        return userMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public List<ActivityNotice> getPageNoticeList(ActivityNoticePageListRequest request) {
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        Integer userId = UserUtils.getUserId();
        queryWrapper.eq("user_id", userId);
        if (!StringUtils.isEmpty(request.getStatus())) {
            queryWrapper.eq("status", request.getStatus());
        }
        queryWrapper.groupBy("activity_id");
        queryWrapper.select("activity_id");
        List<ActivityClock> activityClocks = activityClockMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(activityClocks)) {
            List<Integer> collect = activityClocks.stream().map(ActivityClock::getActivityId).collect(Collectors.toList());
            return activityNoticeMapper.selectBatchIds(collect);
        }
        return new ArrayList<>();
    }

    @Override
    public List<ActivityClockResponse> getUserActivityClock(ActivityNoticePageListRequest request) {
        List<ActivityClockResponse> activityClockResponses = new ArrayList<>();
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper();
        Integer userId = UserUtils.getUserId();
        queryWrapper.select("id", "activity_id", "user_id", "start_time", "end_time", "create_time", "update_time", "sum(duration) duration", "status", "sign_up", "longitude", "latitude");
        queryWrapper.eq("user_id", userId);
        if (!StringUtils.isEmpty(request.getStatus())) {
            queryWrapper.eq("status", request.getStatus());
        }
        queryWrapper.groupBy("activity_id");
        queryWrapper.select("activity_id");
        List<ActivityClock> activityClocks = activityClockMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(activityClocks)) {
            List<Integer> collect = activityClocks.stream().map(ActivityClock::getActivityId).collect(Collectors.toList());
            List<ActivityNotice> activityNotices = activityNoticeMapper.selectBatchIds(collect);
            for (ActivityClock activityClock : activityClocks) {
                for (ActivityNotice activityNotice : activityNotices) {
                    if (activityClock.getActivityId() == activityNotice.getId()) {
                        ActivityClockResponse activityClockResponse = new ActivityClockResponse();
                        BeanUtils.copyProperties(activityClock, activityClockResponse);
                        BeanUtils.copyProperties(activityNotice, activityClockResponse);
                        activityClockResponses.add(activityClockResponse);
                    }
                }
            }
        }
        return activityClockResponses;
    }

    @Override
    public Integer getCount(Integer userId) {
        QueryWrapper<ActivityClock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", UserUtils.getUserId());
        return activityClockMapper.selectCount(queryWrapper);
    }
}
