package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.Product;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.mapper.ProductMapper;
import com.cc.wydk.mapper.VolunteerTeamMapper;
import com.cc.wydk.request.ProductDetailRequest;
import com.cc.wydk.request.ProductPageListRequest;
import com.cc.wydk.request.VolunteerTeamDetailRequest;
import com.cc.wydk.request.VolunteerTeamPageListRequest;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.ProductService;
import com.cc.wydk.service.VolunteerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final ProductMapper productMapper;


    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public IPage<Product> getPageList(ProductPageListRequest request) {
        Page<Product> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<Product> queryWrapperUser = new QueryWrapper();
        if (null != request.getType()) {
            queryWrapperUser.eq("product_type", request.getType());
        }
        queryWrapperUser.eq("is_delete", 0);

        queryWrapperUser.orderByDesc("create_time");
        return productMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public Product getById(ProductDetailRequest request) {
        return productMapper.selectById(request.getId());
    }
}
