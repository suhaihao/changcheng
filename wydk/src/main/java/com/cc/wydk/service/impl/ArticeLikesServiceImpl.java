package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.*;
import com.cc.wydk.mapper.*;
import com.cc.wydk.request.ArticeLikesCountRequest;
import com.cc.wydk.request.ArticeLikesPageListRequest;
import com.cc.wydk.response.ArticeLikesResponse;
import com.cc.wydk.service.ArticeLikesService;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticeLikesServiceImpl extends ServiceImpl<ArticeLikesMapper, ArticeLikes> implements ArticeLikesService {

    private final ArticeLikesMapper articeLikesMapper;
    private final RedListMapper redListMapper;
    private final BlackListMapper blackListMapper;
    private final FiveFormMapper fiveFormMapper;
    private final CivilizedClassroomMapper civilizedClassroomMapper;
    private final TenProductsMapper tenProductsMapper;

    @Autowired
    public ArticeLikesServiceImpl(ArticeLikesMapper articeLikesMapper, RedListMapper redListMapper, BlackListMapper blackListMapper, FiveFormMapper fiveFormMapper, CivilizedClassroomMapper civilizedClassroomMapper, TenProductsMapper tenProductsMapper) {
        this.articeLikesMapper = articeLikesMapper;
        this.redListMapper = redListMapper;
        this.blackListMapper = blackListMapper;
        this.fiveFormMapper = fiveFormMapper;
        this.civilizedClassroomMapper = civilizedClassroomMapper;
        this.tenProductsMapper = tenProductsMapper;
    }


    @Override
    public IPage<ArticeLikes> getPageList(ArticeLikesPageListRequest request) {
        Page<ArticeLikes> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeLikes> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.eq("user_id", UserUtils.getUserId());
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.eq("is_delete", "0");
        queryWrapperUser.orderByDesc("create_time");
        return articeLikesMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public Integer getLikesCount(ArticeLikesCountRequest request) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("artice_id", request.getArticeId());
        if (null != request.getType()) {
            queryWrapper.eq("type", request.getType());
        }
        queryWrapper.eq("is_delete", "0");
        return articeLikesMapper.selectCount(queryWrapper);
    }

    @Override
    public List<ArticeLikesResponse> getLikePageList(ArticeLikesPageListRequest request) {
        List<ArticeLikesResponse> likesResponses = new ArrayList<>();
        Page<ArticeLikes> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeLikes> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.eq("user_id", UserUtils.getUserId());
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.eq("is_delete", "0");
        queryWrapperUser.orderByDesc("create_time");
        IPage<ArticeLikes> articeLikesIPage = articeLikesMapper.selectPage(page, queryWrapperUser);
        List<ArticeLikes> records = articeLikesIPage.getRecords();
        if (!CollectionUtils.isEmpty(records)) {
            List<Integer> collect = records.stream().map(ArticeLikes::getArticeId).collect(Collectors.toList());
            if (request.getType() == 0) {
                List<RedList> redLists = redListMapper.selectBatchIds(collect);
                for (ArticeLikes articeLikes : records) {
                    for (RedList redList : redLists) {
                        if (articeLikes.getArticeId() == redList.getId()) {
                            ArticeLikesResponse articeLikesResponse = new ArticeLikesResponse();
                            BeanUtils.copyProperties(articeLikes, articeLikesResponse);
                            articeLikesResponse.setTitle(redList.getTitle());
                            likesResponses.add(articeLikesResponse);
                        }
                    }
                }
            } else if (request.getType() == 1) {
                List<BlackList> blackLists = blackListMapper.selectBatchIds(collect);
                for (ArticeLikes articeLikes : records) {
                    for (BlackList blackList : blackLists) {
                        if (articeLikes.getArticeId() == blackList.getId()) {
                            ArticeLikesResponse articeLikesResponse = new ArticeLikesResponse();
                            BeanUtils.copyProperties(articeLikes, articeLikesResponse);
                            articeLikesResponse.setTitle(blackList.getTitle());
                            likesResponses.add(articeLikesResponse);
                        }
                    }
                }
            } else if (request.getType() == 2) {
                List<FiveForm> fiveForms = fiveFormMapper.selectBatchIds(collect);
                for (ArticeLikes articeLikes : records) {
                    for (FiveForm fiveForm : fiveForms) {
                        if (articeLikes.getArticeId() == fiveForm.getId()) {
                            ArticeLikesResponse articeLikesResponse = new ArticeLikesResponse();
                            BeanUtils.copyProperties(articeLikes, articeLikesResponse);
                            articeLikesResponse.setTitle(fiveForm.getName());
                            likesResponses.add(articeLikesResponse);
                        }
                    }
                }
            } else if (request.getType() == 3) {
                List<CivilizedClassroom> civilizedClassrooms = civilizedClassroomMapper.selectBatchIds(collect);
                for (ArticeLikes articeLikes : records) {
                    for (CivilizedClassroom civilizedClassroom : civilizedClassrooms) {
                        if (articeLikes.getArticeId() == civilizedClassroom.getId()) {
                            ArticeLikesResponse articeLikesResponse = new ArticeLikesResponse();
                            BeanUtils.copyProperties(articeLikes, articeLikesResponse);
                            articeLikesResponse.setTitle(civilizedClassroom.getTitle());
                            likesResponses.add(articeLikesResponse);
                        }
                    }
                }
            } else if (request.getType() == 4) {
                List<TenProducts> tenProducts = tenProductsMapper.selectBatchIds(collect);
                for (ArticeLikes articeLikes : records) {
                    for (TenProducts tenProducts1 : tenProducts) {
                        if (articeLikes.getArticeId() == tenProducts1.getId()) {
                            ArticeLikesResponse articeLikesResponse = new ArticeLikesResponse();
                            BeanUtils.copyProperties(articeLikes, articeLikesResponse);
                            articeLikesResponse.setTitle(tenProducts1.getTitle());
                            likesResponses.add(articeLikesResponse);
                        }
                    }
                }
            }
        }
        return likesResponses;
    }
}
