package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.RecommendedPeople;
import com.cc.wydk.mapper.RecommendedPeopleMapper;
import com.cc.wydk.request.RecommendedPeoplePageListRequest;
import com.cc.wydk.service.RecommendedPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendedPeopleServiceImpl extends ServiceImpl<RecommendedPeopleMapper, RecommendedPeople> implements RecommendedPeopleService {

    private final RecommendedPeopleMapper recommendedPeopleMapper;


    @Autowired
    public RecommendedPeopleServiceImpl(RecommendedPeopleMapper recommendedPeopleMapper) {
        this.recommendedPeopleMapper = recommendedPeopleMapper;
    }


    @Override
    public IPage<RecommendedPeople> getPageList(RecommendedPeoplePageListRequest request) {
        Page<RecommendedPeople> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<RecommendedPeople> queryWrapperUser = new QueryWrapper();
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        return recommendedPeopleMapper.selectPage(page, queryWrapperUser);
    }
}
