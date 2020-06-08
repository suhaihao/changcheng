package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.RecommendedPeople;
import com.cc.wydk.request.RecommendedPeoplePageListRequest;

public interface RecommendedPeopleService extends IService<RecommendedPeople> {

    IPage<RecommendedPeople> getPageList(RecommendedPeoplePageListRequest request);
}
