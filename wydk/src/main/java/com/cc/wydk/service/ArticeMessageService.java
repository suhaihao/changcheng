package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.entity.ArticeMessage;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import com.cc.wydk.request.ArticeMessagePageListRequest;
import com.cc.wydk.response.ArticeMessagePageResoinse;

public interface ArticeMessageService extends IService<ArticeMessage> {


    /**
     * 分页获取文章列表请求提
     * @return
     */
    IPage<ArticeMessagePageResoinse> getPageList(ArticeMessagePageListRequest request);


}
