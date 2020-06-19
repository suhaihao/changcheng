package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.ArticeCollection;
import com.cc.wydk.request.ArticeCollectionDetailRequest;
import com.cc.wydk.request.ArticeCollectionPageListRequest;
import com.cc.wydk.request.ArticeCollectionSaveRequest;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.ArticeCollectionService;
import com.cc.wydk.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/collection")
@CrossOrigin
@Api("收藏接口")
public class ArticeCollectionController {

    private final ArticeCollectionService articeCollectionService;

    @Autowired
    public ArticeCollectionController(ArticeCollectionService articeCollectionService) {
        this.articeCollectionService = articeCollectionService;
    }

    @PostMapping("/getByPageList")
    @ApiOperation(value = "分页获取收藏列表")
    public ResultBean<IPage<ArticeCollection>> getByPageList(@RequestBody ArticeCollectionPageListRequest request) {
        return new ResultBean<>(articeCollectionService.getPageList(request));
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "收藏添加修改")
    public ResultBean<Boolean> getUpdate(@Valid @RequestBody ArticeCollectionSaveRequest request) {
        ArticeCollection ArticeCollection = new ArticeCollection();
        BeanUtils.copyProperties(request, ArticeCollection);
        if (null == ArticeCollection.getId()) {
            ArticeCollection.setCreateTime(LocalDateTime.now());
            ArticeCollection.setUserId(UserUtils.getUserId());
        }
        return new ResultBean<>(articeCollectionService.saveOrUpdate(ArticeCollection));
    }

    @PostMapping("/detail")
    @ApiOperation(value = "收藏详情")
    public ResultBean<ArticeCollection> getDetail(@Valid @RequestBody ArticeCollectionDetailRequest request) {
        return new ResultBean<>(articeCollectionService.getById(request.getId()));
    }

    @PostMapping("/del")
    @ApiOperation(value = "收藏刪除")
    public ResultBean<Boolean> getDelete(@Valid @RequestBody ArticeCollectionDetailRequest request) {
        return new ResultBean<>(articeCollectionService.removeById(request.getId()));
    }

}
