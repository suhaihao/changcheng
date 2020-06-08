package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.mapper.VolunteerTeamMapper;
import com.cc.wydk.request.VolunteerTeamDetailRequest;
import com.cc.wydk.request.VolunteerTeamPageListRequest;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.VolunteerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VolunteerTeamServiceImpl extends ServiceImpl<VolunteerTeamMapper, VolunteerTeam> implements VolunteerTeamService {

    private final VolunteerTeamMapper volunteerTeamMapper;


    @Autowired
    public VolunteerTeamServiceImpl(VolunteerTeamMapper volunteerTeamMapper) {
        this.volunteerTeamMapper = volunteerTeamMapper;
    }


    @Override
    public IPage<VolunteerTeamResponse> getRankingPageList(VolunteerTeamPageListRequest request) {
        Page<VolunteerTeamResponse> page = new Page<>(request.getPageIndex(), request.getPageSize());
        return volunteerTeamMapper.getRankingList(page);
    }

    @Override
    public IPage<VolunteerTeam> getPageList(VolunteerTeamPageListRequest request) {
        Page<VolunteerTeam> page = new Page<>(request.getPageIndex(), request.getPageSize());
        QueryWrapper<VolunteerTeam> queryWrapperUser = new QueryWrapper();
        if (!StringUtils.isEmpty(request.getTeamName())) {
            queryWrapperUser.like("team_name", "%" + request.getTeamName() + "%");
        }
        return volunteerTeamMapper.selectPage(page, queryWrapperUser);
    }

    @Override
    public VolunteerTeam getById(VolunteerTeamDetailRequest request) {
        return volunteerTeamMapper.selectById(request.getId());
    }
}