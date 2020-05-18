package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.FiveForm;
import com.cc.wydk.mapper.FiveFormMapper;
import com.cc.wydk.request.FiveFormPageListRequest;
import com.cc.wydk.service.FiveFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiveFormServiceImpl extends ServiceImpl<FiveFormMapper, FiveForm> implements FiveFormService {

    private final FiveFormMapper fiveFormMapper;


    @Autowired
    public FiveFormServiceImpl(FiveFormMapper fiveFormMapper) {
        this.fiveFormMapper = fiveFormMapper;
    }


    @Override
    public IPage<FiveForm> getPageList(FiveFormPageListRequest request) {
        Page<FiveForm> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<FiveForm> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.orderByDesc("create_time");
        return fiveFormMapper.selectPage(page, queryWrapperUser);
    }
}
