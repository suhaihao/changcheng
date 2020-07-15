package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.entity.ActivityNotice;
import com.cc.wydk.entity.User;
import com.cc.wydk.request.*;
import com.cc.wydk.response.ActivityClockResponse;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.ActivityClockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clock")
@CrossOrigin
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


}
