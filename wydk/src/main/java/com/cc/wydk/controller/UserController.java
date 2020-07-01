package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.UserJoinTemLog;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.request.UserAddRequest;
import com.cc.wydk.request.UserJoinTeamLogAddRequest;
import com.cc.wydk.request.UserPageListRequest;
import com.cc.wydk.request.UserQueryRequest;
import com.cc.wydk.respond.UserRankingResponse;
import com.cc.wydk.respond.UserResPonse;
import com.cc.wydk.service.UserJoinTemLogService;
import com.cc.wydk.service.UserService;
import com.cc.wydk.service.VolunteerTeamService;
import com.cc.wydk.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
@Api("用户接口信息")
public class UserController {

    private final UserService userService;
    private final UserJoinTemLogService userJoinTemLogService;
    private final VolunteerTeamService volunteerTeamService;

    @Autowired
    public UserController(UserService userService, UserJoinTemLogService userJoinTemLogService, VolunteerTeamService volunteerTeamService) {
        this.userService = userService;
        this.userJoinTemLogService = userJoinTemLogService;
        this.volunteerTeamService = volunteerTeamService;
    }


    @PostMapping("/queryUser")
    @ApiOperation(value = "获取用户信息")
    public UserResPonse saveVolunteerOrder(@Valid @RequestBody UserQueryRequest request) {
        return userService.getById(request);
    }

    @PostMapping("/queryUserId")
    @ApiOperation(value = "获取用户id")
    public Integer getUserId() {
        return UserUtils.getUserId();
    }

    @PostMapping("/rankingUser")
    @ApiOperation(value = "获取用户排行")
    public IPage<UserRankingResponse> rankingUser(@RequestBody UserPageListRequest request) {
        return userService.getRankingUser(request);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "用户注册")
    public Boolean addUser(@Valid @RequestBody UserAddRequest request) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", request.getPhone());
        User user = userService.getOne(queryWrapper);
        if (null != user) {
            throw new BusinessInterfaceException("该手机号已注册");
        }
        user = new User();
        BeanUtils.copyProperties(request, user);
        user.setNickname(request.getFullname());
        user.setGrade("初级");
        user.setHeadImg("");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateBy(1);
        user.setUpdateBy(1);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.save(user);
    }

    @PostMapping("/join")
    @ApiOperation(value = "用户加入团队申请")
    public Boolean join(@Valid @RequestBody UserJoinTeamLogAddRequest request) {

        if (null == request.getId()) {
            UserJoinTemLog userJoinTemLog = new UserJoinTemLog();
            BeanUtils.copyProperties(request, userJoinTemLog);
            VolunteerTeam byId = volunteerTeamService.getById(request.getVolunteerTeamId());
            if (null == byId) {
                throw new BusinessInterfaceException("未查到团队信息");
            }
            userJoinTemLog.setUserId(UserUtils.getUserId());
            return userJoinTemLogService.save(userJoinTemLog);
        } else {
            if (request.getIsExamine() == 1) {
                VolunteerTeam byId = volunteerTeamService.getById(request.getVolunteerTeamId());
                if (null == byId) {
                    throw new BusinessInterfaceException("未查到团队信息");
                }
                User byId1 = userService.getById(request.getId());
                if (null == byId1) {
                    throw new BusinessInterfaceException("未查到用户信息");
                }
                byId1.setTeam(String.valueOf(byId.getId()));
                userService.updateById(byId1);
                return true;
            }
            return false;
        }
    }

}
