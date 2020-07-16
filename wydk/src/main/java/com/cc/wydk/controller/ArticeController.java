package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.Artice;
import com.cc.wydk.request.ArticeDetailRequest;
import com.cc.wydk.request.ArticePageListRequest;
import com.cc.wydk.request.ArticeUpdateRequest;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.ArticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/artice")
@CrossOrigin
@Api("文章")
public class ArticeController {

    private final ArticeService articeService;

    @Autowired
    public ArticeController(ArticeService articeService) {
        this.articeService = articeService;
    }

    @PostMapping("/getByPageList")
    @ApiOperation(value = "分页获取文章列表")
    public ResultBean<IPage<Artice>> getByPageList(@RequestBody ArticePageListRequest request) {
        return new ResultBean<>(articeService.getPageList(request));
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "文章添加修改")
    public ResultBean<Boolean> getUpdate(@Valid @RequestBody ArticeUpdateRequest request) {
        Artice artice = new Artice();
        BeanUtils.copyProperties(request, artice);
        if (null == artice.getId()) {
            artice.setReleaseTime(LocalDateTime.now());
            artice.setCreateTime(LocalDateTime.now());
            artice.setUpdateTiem(LocalDateTime.now());
        }
        return new ResultBean<>(articeService.saveOrUpdate(artice));
    }

    @PostMapping("/detail")
    @ApiOperation(value = "文章详情")
    public ResultBean<Artice> getDetail(@Valid @RequestBody ArticeDetailRequest request) {
        return new ResultBean<>(articeService.getById(request.getId()));
    }

    @PostMapping("/del")
    @ApiOperation(value = "文章刪除")
    public ResultBean<Boolean> getDelete(@Valid @RequestBody ArticeDetailRequest request) {
        return new ResultBean<>(articeService.removeById(request.getId()));
    }

}
