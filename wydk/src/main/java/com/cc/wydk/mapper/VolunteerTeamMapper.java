package com.cc.wydk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.respond.UserRankingResponse;
import com.cc.wydk.respond.VolunteerTeamResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface VolunteerTeamMapper extends BaseMapper<VolunteerTeam> {

    /**
     * 分页获取排行信息
     *
     * @param page
     * @return
     */
    @Select(value = "select  (@r :=@r + 1) as rowNum ,a.* from (select s.*,count(u.id) teamCount from volunteer_team s left join user u on s.id=u.team group by s.id,u.team order by s.service_duration desc ) a ,(select @r := 0) r")
    IPage<VolunteerTeamResponse> getRankingList(Page page);

    /**
     * 分页获取排行信息
     *
     * @param page
     * @return
     */
    @Select(value = "select  (@r :=@r + 1) as rowNum ,a.* from (select s.*,count(u.id) teamCount from volunteer_team s left join user u on s.id=u.team where s.team_name like #{teameName} group by s.id,u.team order by s.service_duration desc ) a ,(select @r := 0) r")
    IPage<VolunteerTeamResponse> getRankingByteamList(Page page, @Param("teameName") String teameName);
}
