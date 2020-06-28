package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import io.swagger.models.auth.In;

public interface ArticeLikesService extends IService<ArticeLikes> {


    /**
     * 分页获取文章列表请求提
     * @return
     */
    IPage<ArticeLikes> getPageList(ArticeLikesPageListRequest request);

    /**
     * 获取文章点赞总数
     * @param request
     * @return
     */
    Integer getLikesCount(ArticeLikesCountRequest request);
}
