package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.ActivityMessage;
import com.cc.wydk.request.ActivityMessagePageListRequest;
import com.cc.wydk.request.ActivityMessageRequest;
import com.cc.wydk.service.ActivityMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/messages")
@CrossOrigin
@Api("留言接口")
public class ActivityMessageController {

    private final ActivityMessageService activityMessageService;

    @Autowired
    public ActivityMessageController(ActivityMessageService activityMessageService) {
        this.activityMessageService = activityMessageService;
    }


    @PostMapping("/getPageList")
    @ApiOperation(value = "分页获取留言集合")
    public IPage<ActivityMessage> getByPageList(@RequestBody ActivityMessagePageListRequest request) {
        return activityMessageService.getPageList(request);
    }

    @PostMapping("/saveActivityMessage")
    @ApiOperation(value = "添加留言")
    public Boolean getByPageList(@RequestBody ActivityMessageRequest request) {
        ActivityMessage activityMessage = new ActivityMessage();
        BeanUtils.copyProperties(request, activityMessage);
        activityMessage.setCreateTime(LocalDateTime.now());
        return activityMessageService.save(activityMessage);
    }


}
