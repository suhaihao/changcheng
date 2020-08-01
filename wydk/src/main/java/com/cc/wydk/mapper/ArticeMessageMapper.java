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


    @Select({"<script>",
            "select m.*,u.fullname,u.nickname,u.head_img from artice_message m,user u where m.user_id=u.id ",
            "<when test='map.type!=null'>",
            "and m.type=#{map.type}",
            "</when>",
            "<when test='map.artice_id!=null'>",
            " and m.artice_id=#{map.artice_id}",
            "</when>",
            "<when test='user!=null'>",
            " and m.user_id=#{userid}",
            "</when>",
            "<when test='map.is_examine != null'>",
            " and m.is_Examine=#{map.is_examine}",
            "</when>",
            " order by create_time desc",
            "</script>"})
    IPage<ArticeMessagePageResoinse> getArticeMessageUserPageList(Page page, @Param("map") Map<String, Object> map, @Param("user") Integer userid);
}
