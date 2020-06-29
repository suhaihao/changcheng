package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.entity.ArticeMessage;
import com.cc.wydk.mapper.ArticeMessageMapper;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import com.cc.wydk.request.ArticeMessagePageListRequest;
import com.cc.wydk.service.ArticeMessageService;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticeMessageServiceImpl extends ServiceImpl<ArticeMessageMapper, ArticeMessage> implements ArticeMessageService {

    private final ArticeMessageMapper articeMessageMapper;


    @Autowired
    public ArticeMessageServiceImpl(ArticeMessageMapper articeMessageMapper) {
        this.articeMessageMapper = articeMessageMapper;
    }


    @Override
    public IPage<ArticeMessage> getPageList(ArticeMessagePageListRequest request) {
        Page<ArticeMessage> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeMessage> queryWrapperUser = new QueryWrapper();
        if (request.getIsUser()) {
            queryWrapperUser.eq("user_id", UserUtils.getUserId());
        }
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        if (null != request.getArticeId()) {
            queryWrapperUser.eq("artice_id", request.getArticeId());
        }
        queryWrapperUser.orderByDesc("create_time");
        return articeMessageMapper.selectPage(page, queryWrapperUser);
    }


}
