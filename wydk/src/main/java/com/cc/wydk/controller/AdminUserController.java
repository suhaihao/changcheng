package com.cc.wydk.controller;

import com.alipay.api.internal.mapping.ApiField;
import com.cc.wydk.entity.AdminUser;
import com.cc.wydk.request.AdminUserAddRequest;
import com.cc.wydk.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/adminUser")
@CrossOrigin
@Api("后台用户接口")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @Autowired
    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @ApiOperation("后台用户注册接口")
    @PostMapping("/addAdminUser")
    public Boolean addAdminUser(@Valid @RequestBody AdminUserAddRequest request) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(request, adminUser);
        adminUser.setCreateTime(LocalDateTime.now());
        return adminUserService.save(adminUser);
    }


}
