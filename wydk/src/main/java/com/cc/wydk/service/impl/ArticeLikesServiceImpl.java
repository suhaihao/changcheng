package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.mapper.ArticeLikesMapper;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import com.cc.wydk.service.ArticeLikesService;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticeLikesServiceImpl extends ServiceImpl<ArticeLikesMapper, ArticeLikes> implements ArticeLikesService {

    private final ArticeLikesMapper articeLikesMapper;


    @Autowired
    public ArticeLikesServiceImpl(ArticeLikesMapper articeLikesMapper) {
        this.articeLikesMapper = articeLikesMapper;
    }


    @Override
    public IPage<ArticeLikes> getPageList(ArticeLikesPageListRequest request) {
        Page<ArticeLikes> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeLikes> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.eq("user_id", UserUtils.getUserId());
        queryWrapperUser.orderByDesc("create_time");
        return articeLikesMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public Integer getLikesCount(ArticeLikesCountRequest request) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("artice_id", request.getArticeId());
        return articeLikesMapper.selectCount(queryWrapper);
    }
}
