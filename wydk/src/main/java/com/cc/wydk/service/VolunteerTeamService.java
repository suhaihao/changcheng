package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.request.VolunteerTeamDetailRequest;
import com.cc.wydk.request.VolunteerTeamPageListRequest;
import com.cc.wydk.respond.VolunteerTeamResponse;

public interface VolunteerTeamService extends IService<VolunteerTeam> {

    /**
     * 分页获取列表信息
     *
     * @param request
     * @return
     */
    IPage<VolunteerTeamResponse> getRankingPageList(VolunteerTeamPageListRequest request);

    /**
     * 根据id获取唯一数据
     * @param request
     * @return
     */
    VolunteerTeam getById(VolunteerTeamDetailRequest request);
}
