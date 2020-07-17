package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.TenProducts;
import com.cc.wydk.request.TenProductsAddOrUpdateRequest;
import com.cc.wydk.request.TenProductsDetailRequest;
import com.cc.wydk.request.TenProductsPageListRequest;
import com.cc.wydk.request.VolunteerTeamPageListRequest;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.TenProductsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ten")
@CrossOrigin
@Api("十大精品接口")
public class TenProductsController {

    private final TenProductsService tenProductsService;

    @Autowired
    public TenProductsController(TenProductsService tenProductsService) {
        this.tenProductsService = tenProductsService;
    }


    @PostMapping("/getPageList")
    @ApiOperation(value = "获取十大形式分页列表")
    public IPage<TenProducts> getByPageList(@RequestBody TenProductsPageListRequest request) {
        return tenProductsService.getPageList(request);
    }

    @PostMapping("/saveOrUpdateTenProducts")
    @ApiOperation(value = "更新或添加十大形式")
    public Boolean getByPageList(@RequestBody TenProductsAddOrUpdateRequest request) {
        TenProducts tenProducts = new TenProducts();
        BeanUtils.copyProperties(request, tenProducts);
        return tenProductsService.saveOrUpdate(tenProducts);
    }

    @PostMapping("/getDetail")
    @ApiOperation(value = "获取十大形式详情")
    public TenProducts getDetail(@Valid @RequestBody TenProductsDetailRequest request) {
        return tenProductsService.getById(request.getId());
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除十大精品")
    public Boolean delTenProducts(@Valid @RequestBody TenProductsDetailRequest request) {
        return tenProductsService.removeById(request.getId());
    }


}
