package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.*;
import com.cc.wydk.mapper.*;
import com.cc.wydk.request.ArticeCollectionPageListRequest;
import com.cc.wydk.response.ArticeCollectionResponse;
import com.cc.wydk.response.ArticeLikesResponse;
import com.cc.wydk.service.ArticeCollectionService;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticeCollectionServiceImpl extends ServiceImpl<ArticCollectionMapper, ArticeCollection> implements ArticeCollectionService {

    private final ArticCollectionMapper articCollectionMapper;
    private final RedListMapper redListMapper;
    private final BlackListMapper blackListMapper;
    private final FiveFormMapper fiveFormMapper;
    private final CivilizedClassroomMapper civilizedClassroomMapper;
    private final TenProductsMapper tenProductsMapper;

    @Autowired
    public ArticeCollectionServiceImpl(ArticCollectionMapper articCollectionMapper, RedListMapper redListMapper, BlackListMapper blackListMapper, FiveFormMapper fiveFormMapper, CivilizedClassroomMapper civilizedClassroomMapper, TenProductsMapper tenProductsMapper) {
        this.articCollectionMapper = articCollectionMapper;
        this.redListMapper = redListMapper;
        this.blackListMapper = blackListMapper;
        this.fiveFormMapper = fiveFormMapper;
        this.civilizedClassroomMapper = civilizedClassroomMapper;
        this.tenProductsMapper = tenProductsMapper;
    }


    @Override
    public IPage<ArticeCollection> getPageList(ArticeCollectionPageListRequest request) {
        Page<ArticeCollection> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeCollection> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.eq("user_id", UserUtils.getUserId());
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.orderByDesc("create_time");
        return articCollectionMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public List<ArticeCollectionResponse> getUserCollectionList(ArticeCollectionPageListRequest request) {
        List<ArticeCollectionResponse> likesResponses = new ArrayList<>();
        Page<ArticeCollection> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<ArticeCollection> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.eq("user_id", UserUtils.getUserId());
        if (null != request.getType()) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.eq("is_delete", "0");
        queryWrapperUser.orderByDesc("create_time");
        IPage<ArticeCollection> articeCollectionIPage = articCollectionMapper.selectPage(page, queryWrapperUser);
        List<ArticeCollection> records = articeCollectionIPage.getRecords();
        if (!CollectionUtils.isEmpty(records)) {
            List<Integer> collect = records.stream().map(ArticeCollection::getArticeId).collect(Collectors.toList());
            if (request.getType() == 0) {
                List<RedList> redLists = redListMapper.selectBatchIds(collect);
                for (ArticeCollection articeCollection : records) {
                    for (RedList redList : redLists) {
                        if (articeCollection.getArticeId() == redList.getId()) {
                            ArticeCollectionResponse articeCollectionResponse = new ArticeCollectionResponse();
                            BeanUtils.copyProperties(articeCollection, articeCollectionResponse);
                            articeCollectionResponse.setTitle(redList.getTitle());
                            likesResponses.add(articeCollectionResponse);
                        }
                    }
                }
            } else if (request.getType() == 1) {
                List<BlackList> blackLists = blackListMapper.selectBatchIds(collect);
                for (ArticeCollection articeCollection : records) {
                    for (BlackList blackList : blackLists) {
                        if (articeCollection.getArticeId() == blackList.getId()) {
                            ArticeCollectionResponse articeCollectionResponse = new ArticeCollectionResponse();
                            BeanUtils.copyProperties(articeCollection, articeCollectionResponse);
                            articeCollectionResponse.setTitle(blackList.getTitle());
                            likesResponses.add(articeCollectionResponse);
                        }
                    }
                }
            } else if (request.getType() == 2) {
                List<FiveForm> fiveForms = fiveFormMapper.selectBatchIds(collect);
                for (ArticeCollection articeCollection : records) {
                    for (FiveForm fiveForm : fiveForms) {
                        if (articeCollection.getArticeId() == fiveForm.getId()) {
                            ArticeCollectionResponse articeCollectionResponse = new ArticeCollectionResponse();
                            BeanUtils.copyProperties(articeCollection, articeCollectionResponse);
                            articeCollectionResponse.setTitle(fiveForm.getName());
                            likesResponses.add(articeCollectionResponse);
                        }
                    }
                }
            } else if (request.getType() == 3) {
                List<CivilizedClassroom> civilizedClassrooms = civilizedClassroomMapper.selectBatchIds(collect);
                for (ArticeCollection articeCollection : records) {
                    for (CivilizedClassroom civilizedClassroom : civilizedClassrooms) {
                        if (articeCollection.getArticeId() == civilizedClassroom.getId()) {
                            ArticeCollectionResponse articeCollectionResponse = new ArticeCollectionResponse();
                            BeanUtils.copyProperties(articeCollection, articeCollectionResponse);
                            articeCollectionResponse.setTitle(civilizedClassroom.getTitle());
                            likesResponses.add(articeCollectionResponse);
                        }
                    }
                }
            } else if (request.getType() == 4) {
                List<TenProducts> tenProducts = tenProductsMapper.selectBatchIds(collect);
                for (ArticeCollection articeCollection : records) {
                    for (TenProducts tenProducts1 : tenProducts) {
                        if (articeCollection.getArticeId() == tenProducts1.getId()) {
                            ArticeCollectionResponse articeCollectionResponse = new ArticeCollectionResponse();
                            BeanUtils.copyProperties(articeCollection, articeCollectionResponse);
                            articeCollectionResponse.setTitle(tenProducts1.getTitle());
                            likesResponses.add(articeCollectionResponse);
                        }
                    }
                }
            }
        }
        return likesResponses;
    }
}
