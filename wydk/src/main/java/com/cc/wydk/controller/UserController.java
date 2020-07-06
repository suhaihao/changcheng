package com.cc.wydk.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.PrizeConvertLog;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.UserJoinTemLog;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.request.*;
import com.cc.wydk.respond.UserRankingResponse;
import com.cc.wydk.respond.UserResPonse;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.PrizeConvertService;
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
    private final PrizeConvertService prizeConvertService;

    @Autowired
    public UserController(UserService userService, UserJoinTemLogService userJoinTemLogService, VolunteerTeamService volunteerTeamService, PrizeConvertService prizeConvertService) {
        this.userService = userService;
        this.userJoinTemLogService = userJoinTemLogService;
        this.volunteerTeamService = volunteerTeamService;
        this.prizeConvertService = prizeConvertService;
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

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户信息")
    public Boolean updateUser(@RequestBody UserUpdateRequest request) {
        User byId = userService.getById(UserUtils.getUserId());
        if (null == byId) {
            throw new BusinessInterfaceException("不能存在的用户");
        }
        if (!StringUtils.isEmpty(request.getPassword())) {
            request.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        }
        if (!StringUtils.isEmpty(request.getPhone())) {
            User user = userService.loginByUserName(request.getPhone());
            if (null != user) {
                throw new BusinessInterfaceException("手机号已存在");
            }
        }
        request.setId(byId.getId());
        BeanUtils.copyProperties(request, byId);
        return userService.updateById(byId);
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

    @PostMapping("/getUserInteger")
    @ApiOperation(value = "登录获取用户信息")
    public ResultBean<User> addUser(@Valid @RequestBody UserGetIntegerRequest request) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = userService.loginByUserName(request.getPhone());
        if (null == user) {
            throw new BusinessInterfaceException("账户不存在");
        }
        if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessInterfaceException("账户密码不正确");
        }
        user.setPassword("");
        return new ResultBean<>(user);
    }


    @PostMapping("/userPrizeConvertPageList")
    @ApiOperation(value = "用户积分兑换列表")
    public ResultBean<IPage<PrizeConvertLog>> userPrizeConvertPageList(@Valid @RequestBody UserPrizeConvertPageListRequest request) {
        Page<PrizeConvertLog> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<PrizeConvertLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", request.getPhone());
        return new ResultBean<>(prizeConvertService.page(page, queryWrapper));
    }

    @PostMapping("/userPrizeConvertDetail")
    @ApiOperation(value = "用户积分兑换详情")
    public ResultBean<PrizeConvertLog> userPrizeConvertPageList(@Valid @RequestBody UserPrizeConvertDetailRequest request) {
        return new ResultBean<>(prizeConvertService.getById(request.getId()));
    }


    @PostMapping("/userPrizeConvert")
    @ApiOperation(value = "用户积分兑换记录")
    public ResultBean<Boolean> userPrizeConvert(@Valid @RequestBody UserPrizeConvertRequest request) {
        User user = userService.loginByUserName(request.getPhone());
        if (null == user) {
            throw new BusinessInterfaceException("不能存在的用户");
        }
        if (request.getIntegral() > 0) {
            if (user.getIntegral() < request.getIntegral()) {
                throw new BusinessInterfaceException("用户积分不足");
            }
            request.setIntegral(request.getIntegral() * -1);
        } else {
            if (user.getIntegral() < request.getIntegral() * -1) {
                throw new BusinessInterfaceException("用户积分不足");
            }
        }
        userService.updateIntegerById(user.getId(), request.getIntegral());
        PrizeConvertLog prizeConvertLog = new PrizeConvertLog();
        prizeConvertLog.setPrizeName(request.getPrizeName());
        prizeConvertLog.setUserId(user.getId());
        prizeConvertLog.setPhone(user.getPhone());
        prizeConvertLog.setIntegral(request.getIntegral());
        prizeConvertLog.setCreateTime(LocalDateTime.now());
        return new ResultBean<>(prizeConvertService.save(prizeConvertLog));
    }

    @PostMapping("/join")
    @ApiOperation(value = "用户加入团队申请")
    public Boolean join(@Valid @RequestBody UserJoinTeamLogAddRequest request) {

        if (null == request.getId()) {
            User user = UserUtils.getUser();
            if (user.getIdNumber() == null) {
                throw new BusinessInterfaceException("您还不是志愿者请完善信息");
            }
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
