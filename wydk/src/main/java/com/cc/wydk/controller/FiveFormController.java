package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.FiveForm;
import com.cc.wydk.entity.TenProducts;
import com.cc.wydk.request.FiveFormAddOrUpdateRequest;
import com.cc.wydk.request.FiveFormPageListRequest;
import com.cc.wydk.request.TenProductsAddOrUpdateRequest;
import com.cc.wydk.request.TenProductsPageListRequest;
import com.cc.wydk.service.FiveFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/five")
@CrossOrigin
@Api("五小形式接口")
public class FiveFormController {

    private final FiveFormService fiveFormService;

    @Autowired
    public FiveFormController(FiveFormService fiveFormService) {
        this.fiveFormService = fiveFormService;
    }


    @PostMapping("/getPageList")
    @ApiOperation(value = "获取十大形式分页列表")
    public IPage<FiveForm> getByPageList(@RequestBody FiveFormPageListRequest request) {
        return fiveFormService.getPageList(request);
    }

    @PostMapping("/saveOrUpdateFiveForm")
    @ApiOperation(value = "更新或添加十大形式")
    public Boolean getByPageList(@RequestBody FiveFormAddOrUpdateRequest request) {
        FiveForm fiveForm = new FiveForm();
        BeanUtils.copyProperties(request, fiveForm);
        return fiveFormService.saveOrUpdate(fiveForm);
    }


}
