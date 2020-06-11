package com.cc.wydk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.respond.UserRankingResponse;
import com.cc.wydk.respond.VolunteerTeamResponse;
import org.apache.ibatis.annotations.Select;

public interface VolunteerTeamMapper extends BaseMapper<VolunteerTeam> {

    /**
     * 分页获取排行信息
     * @param page
     * @return
     */
    @Select(value = "select (@r :=@r + 1) as rowNum,s.*,count(u.id) teamCount from rx_volunteer_team s,(select @r := 0) r,rx_user u where s.id=u.team group by u.team order by s.service_duration desc")
    IPage<VolunteerTeamResponse> getRankingList(Page page);
}
