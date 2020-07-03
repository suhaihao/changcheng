package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.entity.ArticeMessage;
import com.cc.wydk.request.*;
import com.cc.wydk.response.ArticeMessagePageResoinse;
import com.cc.wydk.response.ResultBean;
import com.cc.wydk.service.ArticeMessageService;
import com.cc.wydk.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/articeMessage")
@CrossOrigin
@Api("文章留言")
public class ArticeMessageController {

    private final ArticeMessageService articeMessageService;

    @Autowired
    public ArticeMessageController(ArticeMessageService articeMessageService) {
        this.articeMessageService = articeMessageService;
    }

    @PostMapping("/getByPageList")
    @ApiOperation(value = "分页获取文章留言列表")
    public ResultBean<IPage<ArticeMessagePageResoinse>> getByPageList(@RequestBody ArticeMessagePageListRequest request) {
        return new ResultBean<>(articeMessageService.getPageList(request));
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "文章留言添加修改")
    public ResultBean<Boolean> saveOrUpdate(@Valid @RequestBody ArticeMessageUpdateRequest request) {
        ArticeMessage articeMessage = new ArticeMessage();
        BeanUtils.copyProperties(request, articeMessage);
        articeMessage.setCreateTime(LocalDateTime.now());
        articeMessage.setUserId(UserUtils.getUserId());
        return new ResultBean<>(articeMessageService.saveOrUpdate(articeMessage));
    }

    @PostMapping("/detail")
    @ApiOperation(value = "文章留言详情")
    public ResultBean<ArticeMessage> getDetail(@Valid @RequestBody ArticeMessageDetailRequest request) {
        return new ResultBean<>(articeMessageService.getById(request.getId()));
    }

    @PostMapping("/del")
    @ApiOperation(value = "文章留言刪除")
    public ResultBean<Boolean> getDelete(@Valid @RequestBody ArticeLikesDetailRequest request) {
        return new ResultBean<>(articeMessageService.removeById(request.getId()));
    }

}
