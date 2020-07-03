package com.cc.wydk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.User;
import com.cc.wydk.respond.UserRankingResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 分页排行
     * @param page
     * @return
     */
    @Select(value = "select (@r :=@r + 1) as rowNum,s.* from user s,(select @r := 0) r order by integral desc")
    Page<UserRankingResponse> getRankingList(Page page);

    @Update(value = "update user set integral=integral+#{integral} where id=#{id}")
    int updateInteger(@Param("integral") int integral,@Param("id") int id);
}
