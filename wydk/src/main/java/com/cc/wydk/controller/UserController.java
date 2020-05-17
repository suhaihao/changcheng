package com.cc.wydk.controller;

import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.request.UserQueryRequest;
import com.cc.wydk.request.VolunteerOrderAddRequest;
import com.cc.wydk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User saveVolunteerOrder(@Valid @RequestBody UserQueryRequest request) {
        return userService.getById(request);
    }


}
