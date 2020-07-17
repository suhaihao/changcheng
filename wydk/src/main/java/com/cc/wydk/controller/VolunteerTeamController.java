package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.request.*;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.VolunteerTeamService;
import com.cc.wydk.utils.UserUtils;
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
    public IPage<VolunteerTeamResponse> getByRankingPageList(@RequestBody VolunteerTeamPageListRequest request) {
        return volunteerTeamService.getRankingPageList(request);
    }

    @PostMapping("/getByPageList")
    @ApiOperation(value = "获取团队")
    public IPage<VolunteerTeam> getByPageList(@RequestBody VolunteerTeamPageListRequest request) {
        return volunteerTeamService.getPageList(request);
    }

    @PostMapping("/getDetail")
    @ApiOperation(value = "获取团队详情")
    public VolunteerTeam getDetail(@RequestBody VolunteerTeamDetailRequest request) {
        return volunteerTeamService.getById(request);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除队伍")
    public Boolean delVolunteerTeam(@RequestBody VolunteerTeamDetailRequest request) {
        return volunteerTeamService.removeById(request.getId());
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "添加更新队伍")
    public Boolean saveOrUpdateVolunteerTeam(@RequestBody VolunteerTeamSaveOrUpdateRequest request) {
        VolunteerTeam volunteerTeam = new VolunteerTeam();
        BeanUtils.copyProperties(request, volunteerTeam);
        if (volunteerTeam.getId() == null) {
            volunteerTeam.setNumberOfServices(0);
            volunteerTeam.setServiceDuration(0);
            volunteerTeam.setCreateTime(LocalDateTime.now());
            volunteerTeam.setUpdateTime(LocalDateTime.now());
        } else {
            volunteerTeam.setUpdateTime(LocalDateTime.now());
        }
        return volunteerTeamService.saveOrUpdate(volunteerTeam);
    }


}
