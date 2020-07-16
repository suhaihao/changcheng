package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ArticeCollection;
import com.cc.wydk.request.ArticeCollectionPageListRequest;
import com.cc.wydk.response.ArticeCollectionResponse;

import java.util.List;

public interface ArticeCollectionService extends IService<ArticeCollection> {

    /**
     * 分页获取文章列表请求提
     *
     * @return
     */
    IPage<ArticeCollection> getPageList(ArticeCollectionPageListRequest request);

    /**
     * 获取用户的收藏列表
     *
     * @param request
     * @return
     */
    List<ArticeCollectionResponse> getUserCollectionList(ArticeCollectionPageListRequest request);
}
