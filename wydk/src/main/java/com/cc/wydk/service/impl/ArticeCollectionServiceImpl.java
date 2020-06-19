package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ArticeCollection;
import com.cc.wydk.mapper.ArticCollectionMapper;
import com.cc.wydk.request.ArticeCollectionPageListRequest;
import com.cc.wydk.service.ArticeCollectionService;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticeCollectionServiceImpl extends ServiceImpl<ArticCollectionMapper, ArticeCollection> implements ArticeCollectionService {

    private final ArticCollectionMapper articCollectionMapper;


    @Autowired
    public ArticeCollectionServiceImpl(ArticCollectionMapper articCollectionMapper) {
        this.articCollectionMapper = articCollectionMapper;
    }


    @Override
    public IPage<ArticeCollection> getPageList(ArticeCollectionPageListRequest request) {
        Page<ArticeCollection> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeCollection> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.eq("user_id", UserUtils.getUserId());
        queryWrapperUser.orderByDesc("create_time");
        return articCollectionMapper.selectPage(page, queryWrapperUser);
    }
}
