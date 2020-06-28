package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesDetailRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import com.cc.wydk.request.ArticeLikesUpdateRequest;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.ArticeLikesService;
import com.cc.wydk.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/articeLikes")
@CrossOrigin
@Api("文章点赞")
public class ArticeLikesController {

    private final ArticeLikesService articeLikesService;

    @Autowired
    public ArticeLikesController(ArticeLikesService articeLikesService) {
        this.articeLikesService = articeLikesService;
    }

    @PostMapping("/getByPageList")
    @ApiOperation(value = "分页获取点赞列表")
    public ResultBean<IPage<ArticeLikes>> getByPageList(@RequestBody ArticeLikesPageListRequest request) {
        return new ResultBean<>(articeLikesService.getPageList(request));
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "文章点赞添加修改")
    public ResultBean<Boolean> saveOrUpdate(@Valid @RequestBody ArticeLikesUpdateRequest request) {
        ArticeLikes artice = new ArticeLikes();
        BeanUtils.copyProperties(request, artice);
        artice.setCreateTime(LocalDateTime.now());
        artice.setSize(1);
        artice.setUserId(UserUtils.getUserId());
        return new ResultBean<>(articeLikesService.saveOrUpdate(artice));
    }

    @PostMapping("/detail")
    @ApiOperation(value = "文章点赞详情")
    public ResultBean<ArticeLikes> getDetail(@Valid @RequestBody ArticeLikesDetailRequest request) {
        return new ResultBean<>(articeLikesService.getById(request.getId()));
    }

    @PostMapping("/del")
    @ApiOperation(value = "文章点赞刪除")
    public ResultBean<Boolean> getDelete(@Valid @RequestBody ArticeLikesDetailRequest request) {
        return new ResultBean<>(articeLikesService.removeById(request.getId()));
    }

    @PostMapping("/getLikeCount")
    @ApiOperation(value = "获取文章点赞总数")
    public ResultBean<Integer> getLikeCount(@Valid @RequestBody ArticeLikesCountRequest request) {
        return new ResultBean<>(articeLikesService.getLikesCount(request));
    }

}
