package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.FiveForm;
import com.cc.wydk.entity.TenProducts;
import com.cc.wydk.request.*;
import com.cc.wydk.service.FiveFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @ApiOperation(value = "获取五小形分页列表")
    public IPage<FiveForm> getByPageList(@RequestBody FiveFormPageListRequest request) {
        return fiveFormService.getPageList(request);
    }

    @PostMapping("/saveOrUpdateFiveForm")
    @ApiOperation(value = "更新或添加五小形")
    public Boolean getByPageList(@RequestBody FiveFormAddOrUpdateRequest request) {
        FiveForm fiveForm = new FiveForm();
        BeanUtils.copyProperties(request, fiveForm);
        return fiveFormService.saveOrUpdate(fiveForm);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "根据id获取")
    public FiveForm getDetail(@Valid @RequestBody FiveFormDetailRequest request) {
        return fiveFormService.getById(request.getId());
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除五小形式")
    public Boolean delFiveForm(@Valid @RequestBody FiveFormDetailRequest request) {
        return fiveFormService.removeById(request.getId());
    }


}
