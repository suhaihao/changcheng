package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.request.UserPageListRequest;
import com.cc.wydk.request.UserQueryRequest;
import com.cc.wydk.request.VolunteerOrderAddRequest;
import com.cc.wydk.respond.UserRankingResponse;
import com.cc.wydk.respond.UserResPonse;
import com.cc.wydk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
@Api("用户接口信息")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/queryUser")
    @ApiOperation(value = "获取用户信息")
    public UserResPonse saveVolunteerOrder(@Valid @RequestBody UserQueryRequest request) {
        return userService.getById(request);
    }

    @PostMapping("/rankingUser")
    @ApiOperation(value = "获取用户排行")
    public IPage<UserRankingResponse> rankingUser(@RequestBody UserPageListRequest request) {
        return userService.getRankingUser(request);
    }

}
