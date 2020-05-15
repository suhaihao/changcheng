package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.mapper.CivilizedClassroomMapper;
import com.cc.wydk.request.CivilizedClassroomPageListRequest;
import com.cc.wydk.service.CivilizedClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CivilizedClassroomServiceImpl extends ServiceImpl<CivilizedClassroomMapper, CivilizedClassroom> implements CivilizedClassroomService {

    private final CivilizedClassroomMapper civilizedClassroomMapper;


    @Autowired
    public CivilizedClassroomServiceImpl(CivilizedClassroomMapper civilizedClassroomMapper) {
        this.civilizedClassroomMapper = civilizedClassroomMapper;
    }


    @Override
    public IPage<CivilizedClassroom> getByPageList(CivilizedClassroomPageListRequest request) {
        Page<CivilizedClassroom> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<CivilizedClassroom> queryWrapperUser = new QueryWrapper();
        if (!StringUtils.isEmpty(request.getType())) {
            queryWrapperUser.eq("type", request.getType());
        }
        queryWrapperUser.orderByDesc("create_time");
        return civilizedClassroomMapper.selectPage(page, queryWrapperUser);
    }
}
