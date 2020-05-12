package com.cc.wydk.controller;

import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.request.ActivityClockGetStatusRequest;
import com.cc.wydk.request.ActivityClockSetStatusRequest;
import com.cc.wydk.request.ActivityClockSignInRequest;
import com.cc.wydk.service.ActivityClockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clock")
@Api("活动签到接口")
public class ActivityClockController {

    private final ActivityClockService activityClockService;

    @Autowired
    public ActivityClockController(ActivityClockService activityClockService) {
        this.activityClockService = activityClockService;
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
    public ActivityClock getStatusActivityClock(@RequestBody ActivityClockGetStatusRequest request) {
        return activityClockService.getByUserIdAndActivityIdAndTime(request);
    }

    @PostMapping("/setUpdateStatus")
    @ApiOperation(value = "修改签到状态接口")
    public Boolean setUpdateStatusActivityClock(@RequestBody ActivityClockSetStatusRequest request) {
        return activityClockService.updateActivityClock(request);
    }


}
