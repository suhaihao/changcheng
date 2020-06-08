package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.TenProducts;
import com.cc.wydk.mapper.TenProductsMapper;
import com.cc.wydk.request.TenProductsPageListRequest;
import com.cc.wydk.service.TenProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenProductsServiceImpl extends ServiceImpl<TenProductsMapper, TenProducts> implements TenProductsService {

    private final TenProductsMapper tenProductsMapper;


    @Autowired
    public TenProductsServiceImpl(TenProductsMapper tenProductsMapper) {
        this.tenProductsMapper = tenProductsMapper;
    }


    @Override
    public IPage<TenProducts> getPageList(TenProductsPageListRequest request) {
        Page<TenProducts> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<TenProducts> queryWrapperUser = new QueryWrapper();
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.orderByDesc("create_time");
        return tenProductsMapper.selectPage(page, queryWrapperUser);
    }
}
