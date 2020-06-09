package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.request.VolunteerOrderAddRequest;
import com.cc.wydk.request.VolunteerOrderDetailRequest;
import com.cc.wydk.request.VolunteerOrderUpdateRequest;
import com.cc.wydk.request.VolunteerPageListRequest;
import com.cc.wydk.service.VolunteerOrderService;
import com.cc.wydk.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin
@Api("志愿者点单")
public class VolunteerOrderController {

    private final VolunteerOrderService volunteerOrderService;

    @Autowired
    public VolunteerOrderController(VolunteerOrderService volunteerOrderService) {
        this.volunteerOrderService = volunteerOrderService;
    }


    @PostMapping("/getByPageList")
    @ApiOperation(value = "获取所有点单记录分页查询")
    public IPage<VolunteerOrder> getByPageList(@RequestBody VolunteerPageListRequest request) {
        return volunteerOrderService.getByPageList(request);
    }

    @PostMapping("/getByPageUserList")
    @ApiOperation(value = "获取点单的所有用户分页")
    public IPage<User> getByPageUserList(@RequestBody VolunteerPageListRequest request) {
        return volunteerOrderService.getByPageUserList(request);
    }

    @PostMapping("/saveVolunteerOrder")
    @ApiOperation(value = "存储下单信息")
    public Boolean saveVolunteerOrder(@RequestBody VolunteerOrderAddRequest request) {
        VolunteerOrder volunteerOrder = new VolunteerOrder();
        BeanUtils.copyProperties(request, volunteerOrder);
        volunteerOrder.setCreateTime(LocalDateTime.now());
        volunteerOrder.setUpdateTime(LocalDateTime.now());
        volunteerOrder.setCreateBy(request.getUserId());
        volunteerOrder.setUpdateBy(request.getUserId());
        volunteerOrder.setCreateBy(UserUtils.getUserId());
        return volunteerOrderService.save(volunteerOrder);
    }

    @PostMapping("/updateVolunteerOrder")
    @ApiOperation(value = "支援点单修改")
    public Boolean updateVolunteerOrder(@RequestBody VolunteerOrderUpdateRequest request) {
        VolunteerOrder volunteerOrder = new VolunteerOrder();
        BeanUtils.copyProperties(request, volunteerOrder);
        return volunteerOrderService.updateById(volunteerOrder);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "点单详情")
    public VolunteerOrder getDetail(@Valid @RequestBody VolunteerOrderDetailRequest request) {
        return volunteerOrderService.getById(request.getId());
    }

    @PostMapping("/joinOrder")
    @ApiOperation(value = "接单")
    public Boolean joinOrder(@Valid @RequestBody VolunteerOrderDetailRequest request) {
        VolunteerOrder byId = volunteerOrderService.getById(request.getId());
        if (null != byId) {
            byId.setUserId(UserUtils.getUserId());
            return volunteerOrderService.updateById(byId);
        }
        return false;
    }

}
