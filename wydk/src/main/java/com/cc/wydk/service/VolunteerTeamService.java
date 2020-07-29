package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.request.VolunteerTeamDetailRequest;
import com.cc.wydk.request.VolunteerTeamPageListRequest;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.response.VolunteamResponse;

public interface VolunteerTeamService extends IService<VolunteerTeam> {

    /**
     * 分页获取列表信息
     *
     * @param request
     * @return
     */
    IPage<VolunteerTeamResponse> getRankingPageList(VolunteerTeamPageListRequest request);

    /**
     * 分页获取团队列表
     *
     * @param request
     * @return
     */
    IPage<VolunteamResponse> getPageList(VolunteerTeamPageListRequest request);

    /**
     * 根据id获取唯一数据
     * @param request
     * @return
     */
    VolunteerTeam getById(VolunteerTeamDetailRequest request);
}
