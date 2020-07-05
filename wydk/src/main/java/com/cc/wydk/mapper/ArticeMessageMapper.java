package com.cc.wydk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.wydk.entity.ArticeMessage;
import com.cc.wydk.response.ArticeMessagePageResoinse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface ArticeMessageMapper extends BaseMapper<ArticeMessage> {

    @Select("select m.*,u.fullname,u.nickname,u.head_img from artice_message m,user u where m.user_id=u.id and m.type=#{map.type} and m.artice_id=#{map.artice_id} order by create_time desc")
    IPage<ArticeMessagePageResoinse> getArticeMessagePageList(Page page, @Param("map") Map<String, Object> map);

    @Select("select m.*,u.fullname,u.nickname,u.head_img from artice_message m,user u where m.user_id=u.id and m.type=#{map.type} and m.artice_id=#{map.artice_id} and m.user_id=#{userid} order by create_time desc")
    IPage<ArticeMessagePageResoinse> getArticeMessageUserPageList(Page page, @Param("map") Map<String, Object> map, @Param("user") Integer userid);
}
