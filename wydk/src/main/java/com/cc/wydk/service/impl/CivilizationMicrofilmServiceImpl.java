package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.CivilizationMicrofilm;
import com.cc.wydk.mapper.CivilizationMicrofilmMapper;
import com.cc.wydk.request.CivilizationMicrofilmPageListRequest;
import com.cc.wydk.service.CivilizationMicrofilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilizationMicrofilmServiceImpl extends ServiceImpl<CivilizationMicrofilmMapper, CivilizationMicrofilm> implements CivilizationMicrofilmService {

    private final CivilizationMicrofilmMapper civilizationMicrofilmMapper;


    @Autowired
    public CivilizationMicrofilmServiceImpl(CivilizationMicrofilmMapper civilizationMicrofilmMapper) {
        this.civilizationMicrofilmMapper = civilizationMicrofilmMapper;
    }


    @Override
    public IPage<CivilizationMicrofilm> getByPageList(CivilizationMicrofilmPageListRequest request) {
        Page<CivilizationMicrofilm> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<CivilizationMicrofilm> queryWrapperUser = new QueryWrapper();
        queryWrapperUser.orderByDesc("create_time");
        return civilizationMicrofilmMapper.selectPage(page, queryWrapperUser);
    }
}
