package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.Artice;
import com.cc.wydk.entity.CivilizationMicrofilm;
import com.cc.wydk.mapper.ArticeMapper;
import com.cc.wydk.request.ArticePageListRequest;
import com.cc.wydk.service.ArticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticeServiceImpl extends ServiceImpl<ArticeMapper, Artice> implements ArticeService {

    private final ArticeMapper articeMapper;


    @Autowired
    public ArticeServiceImpl(ArticeMapper articeMapper) {
        this.articeMapper = articeMapper;
    }


    @Override
    public IPage<Artice> getPageList(ArticePageListRequest request) {
        Page<Artice> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<Artice> queryWrapperUser = new QueryWrapper();

        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }

        if (null != request.getTypeId()) {
            queryWrapperUser.eq("type_id", request.getTypeId());
        }

        queryWrapperUser.orderByDesc("create_time");
        return articeMapper.selectPage(page, queryWrapperUser);
    }
}
