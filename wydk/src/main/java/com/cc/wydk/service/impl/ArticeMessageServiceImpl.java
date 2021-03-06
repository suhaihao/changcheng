package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.ArticeMessage;
import com.cc.wydk.mapper.ArticeMessageMapper;
import com.cc.wydk.request.ArticeMessagePageListRequest;
import com.cc.wydk.response.ArticeMessagePageResoinse;
import com.cc.wydk.service.ArticeMessageService;
import com.cc.wydk.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArticeMessageServiceImpl extends ServiceImpl<ArticeMessageMapper, ArticeMessage> implements ArticeMessageService {

    private final ArticeMessageMapper articeMessageMapper;


    @Autowired
    public ArticeMessageServiceImpl(ArticeMessageMapper articeMessageMapper) {
        this.articeMessageMapper = articeMessageMapper;
    }


    @Override
    public IPage<ArticeMessagePageResoinse> getPageList(ArticeMessagePageListRequest request) {
        Page<ArticeMessagePageResoinse> page = new Page<>(request.getPageIndex(), request.getPageSize());
        Map<String, Object> map = new HashMap<>();
        if (null != request.getType()) {
            map.put("type", request.getType());
        }
        if (null != request.getArticeId()) {
            map.put("artice_id", request.getArticeId());
        }
        if (null != request.getIsExamine()) {
            map.put("is_examine", request.getIsExamine());
        }
        if (request.getIsUser()) {
            return articeMessageMapper.getArticeMessageUserPageList(page, map, UserUtils.getUserId());
        } else {
            return articeMessageMapper.getArticeMessageUserPageList(page, map, null);
        }

    }


}
