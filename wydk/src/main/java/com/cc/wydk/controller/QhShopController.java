package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.entity.QhShop;
import com.cc.wydk.entity.TenProducts;
import com.cc.wydk.request.*;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.QhShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/shop")
@CrossOrigin
@Api("积分兑换商户接口")
public class QhShopController {

    private final QhShopService qhShopService;

    @Autowired
    public QhShopController(QhShopService qhShopService) {
        this.qhShopService = qhShopService;
    }


    @PostMapping("/getPageList")
    @ApiOperation(value = "获取商户列表接口")
    public ResultBean<IPage<QhShop>> getByPageList(@RequestBody QhShopPageListRequest request) {
        Page<QhShop> page = new Page<>(request.getPageIndex(), request.getPageSize());
        return new ResultBean<>(qhShopService.page(page));
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "更新添加商户")
    public Boolean getByPageList(@RequestBody QhShopSaveOrUpdateRequest request) {
        QhShop qhShop = new QhShop();
        BeanUtils.copyProperties(request, qhShop);
        if (null == qhShop.getId()) {
            qhShop.setCreateTime(LocalDateTime.now());
        }
        return qhShopService.saveOrUpdate(qhShop);
    }


}
