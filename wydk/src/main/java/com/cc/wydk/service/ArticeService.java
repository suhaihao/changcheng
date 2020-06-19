package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.Artice;
import com.cc.wydk.request.ArticePageListRequest;

public interface ArticeService extends IService<Artice> {

    /**
     * 分页获取文章列表请求提
     * @return
     */
    IPage<Artice> getPageList(ArticePageListRequest request);

}
