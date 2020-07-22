package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.Product;
import com.cc.wydk.request.ProductDetailRequest;
import com.cc.wydk.request.ProductPageListRequest;

public interface ProductService extends IService<Product> {

    /**
     * 分页获取团队列表
     *
     * @param request
     * @return
     */
    IPage<Product> getPageList(ProductPageListRequest request);

    /**
     * 根据id获取唯一数据
     *
     * @param request
     * @return
     */
    Product getById(ProductDetailRequest request);

}
