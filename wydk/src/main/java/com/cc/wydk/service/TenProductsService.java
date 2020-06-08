package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.TenProducts;
import com.cc.wydk.request.TenProductsPageListRequest;

public interface TenProductsService extends IService<TenProducts> {

    /**
     * 分页获取列表信息
     *
     * @param request
     * @return
     */
    IPage<TenProducts> getPageList(TenProductsPageListRequest request);
}
