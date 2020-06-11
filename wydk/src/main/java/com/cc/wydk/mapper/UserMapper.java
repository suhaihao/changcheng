package com.cc.wydk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.User;
import com.cc.wydk.respond.UserRankingResponse;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 分页排行
     * @param page
     * @return
     */
    @Select(value = "select (@r :=@r + 1) as rowNum,s.* from rx_user s,(select @r := 0) r order by integral desc")
    Page<UserRankingResponse> getRankingList(Page page);
}
