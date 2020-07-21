package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.entity.ActivityNotice;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.request.*;
import com.cc.wydk.response.ActivityClockResponse;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.ActivityClockService;
import com.cc.wydk.service.UserService;
import com.cc.wydk.service.VolunteerTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clock")
@CrossOrigin
@Api("活动签到接口")
public class ActivityClockController {

    private final ActivityClockService activityClockService;
    private final VolunteerTeamService volunteerTeamService;
    private final UserService userService;

    @Autowired
    public ActivityClockController(ActivityClockService activityClockService, VolunteerTeamService volunteerTeamService, UserService userService) {
        this.activityClockService = activityClockService;
        this.volunteerTeamService = volunteerTeamService;
        this.userService = userService;
    }

    @PostMapping("/SignIn")
    @ApiOperation(value = "参加活动接口")
    public Boolean SignInActivityClock(@RequestBody ActivityClockSignInRequest request) {
        return activityClockService.saveActivityClock(request);
    }

    @PostMapping("/SelectByActivity")
    @ApiOperation(value = "查找用户是否参加过活动")
    public Boolean SelectByActivity(@RequestBody ActivityClockGetStatusRequest request) {
        return activityClockService.getByActivityIdAndUserId(request);
    }

    @PostMapping("/getStatus")
    @ApiOperation(value = "获取今天该用户的活动状态")
    public ResultBean<ActivityClock> getStatusActivityClock(@RequestBody ActivityClockGetStatusRequest request) {
        return new ResultBean<>(activityClockService.getByUserIdAndActivityIdAndTime(request));
    }

    @PostMapping("/setUpdateStatus")
    @ApiOperation(value = "修改签到状态接口")
    public Boolean setUpdateStatusActivityClock(@RequestBody ActivityClockSetStatusRequest request) {
        return activityClockService.updateActivityClock(request);
    }

    @PostMapping("/getPageClockList")
    @ApiOperation(value = "获得当前活动的所有报名人")
    public IPage<User> getPageClockList(@RequestBody ActivityClockPageListRequest request) {
        return activityClockService.getPageClockList(request);
    }

    @PostMapping("/getPageNoticeList")
    @ApiOperation(value = "获取用户参加过的活动列表")
    public List<ActivityNotice> getPageNoticeList(@RequestBody ActivityNoticePageListRequest request) {
        return activityClockService.getPageNoticeList(request);
    }

    @PostMapping("/getUserActivityClock")
    @ApiOperation(value = "获取用户活动打卡记录")
    public List<ActivityClockResponse> getUserActivityClock(@RequestBody ActivityNoticePageListRequest request) {
        return activityClockService.getUserActivityClock(request);
    }

    @PostMapping("/check")
    @ApiOperation(value = "审核打卡记录")
    public Boolean checkActivityClock(@Valid @RequestBody ActivityClockDetailRequest request) {
        ActivityClock byId = activityClockService.getById(request.getId());
        if (null == byId) {
            throw new BusinessInterfaceException("未查到打卡记录");
        }
        byId.setIsCheck(request.getIsCheck());
        if (request.getIsCheck() == 0) {
            int duration = Integer.parseInt(byId.getDuration());
            User user = userService.getById(byId.getUserId());
            if (null != user) {
                user.setService(user.getService() - (duration / 60 / 60 + 1));
                user.setIntegral(user.getIntegral() - (duration / 60 / 60 + 1));
            }
            userService.updateById(user);
            if (!user.getTeam().equals("0")) {
                VolunteerTeam volunteerTeam = volunteerTeamService.getById(user.getTeam());
                if (null != volunteerTeam) {
                    volunteerTeam.setServiceDuration(volunteerTeam.getServiceDuration() - duration);
                    volunteerTeam.setNumberOfServices(volunteerTeam.getNumberOfServices() - 1);
                }
                volunteerTeamService.updateById(volunteerTeam);
            }

        }
        return activityClockService.updateById(byId);
    }


}
