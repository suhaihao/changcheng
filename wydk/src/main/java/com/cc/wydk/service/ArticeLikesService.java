package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ArticeLikes;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import com.cc.wydk.response.ArticeLikesResponse;
import io.swagger.models.auth.In;

import java.util.List;

public interface ArticeLikesService extends IService<ArticeLikes> {


    /**
     * 分页获取文章列表请求提
     *
     * @return
     */
    IPage<ArticeLikes> getPageList(ArticeLikesPageListRequest request);

    /**
     * 获取文章点赞总数
     *
     * @param request
     * @return
     */
    Integer getLikesCount(ArticeLikesCountRequest request);

    /**
     * 分页获取喜欢的文章集合
     *
     * @param request
     * @return
     */
    List<ArticeLikesResponse> getLikePageList(ArticeLikesPageListRequest request);
}
