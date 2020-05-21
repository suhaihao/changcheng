package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.request.*;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.VolunteerTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/team")
@CrossOrigin
@Api("团队接口")
public class VolunteerTeamController {

    private final VolunteerTeamService volunteerTeamService;

    @Autowired
    public VolunteerTeamController(VolunteerTeamService volunteerTeamService) {
        this.volunteerTeamService = volunteerTeamService;
    }


    @PostMapping("/getByRankingPageList")
    @ApiOperation(value = "获取团队排行")
    public IPage<VolunteerTeamResponse> getByPageList(@RequestBody VolunteerTeamPageListRequest request) {
        return volunteerTeamService.getRankingPageList(request);
    }

    @PostMapping("/getDetail")
    @ApiOperation(value = "获取团队详情")
    public VolunteerTeam getDetail(@RequestBody VolunteerTeamDetailRequest request) {
        return volunteerTeamService.getById(request);
    }


}
