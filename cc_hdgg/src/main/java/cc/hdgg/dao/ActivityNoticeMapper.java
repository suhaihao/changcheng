package cc.hdgg.dao;

import cc.hdgg.entity.ActivityNotice;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ActivityNoticeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @Delete({
            "delete from activity_notice",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @Insert({
            "insert into activity_notice (id, title, ",
            "address, participate_num, ",
            "total_num, contacts, ",
            "phone, imgs, start_time, ",
            "end_time, create_time, ",
            "create_by, update_tiem, ",
            "update_by, content)",
            "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
            "#{address,jdbcType=VARCHAR}, #{participateNum,jdbcType=INTEGER}, ",
            "#{totalNum,jdbcType=INTEGER}, #{contacts,jdbcType=VARCHAR}, ",
            "#{phone,jdbcType=VARCHAR}, #{imgs,jdbcType=VARCHAR}, #{startTime,jdbcType=TIMESTAMP}, ",
            "#{endTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{createBy,jdbcType=INTEGER}, #{updateTiem,jdbcType=TIMESTAMP}, ",
            "#{updateBy,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ActivityNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @InsertProvider(type = ActivityNoticeSqlProvider.class, method = "insertSelective")
    int insertSelective(ActivityNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @Select({
            "select",
            "id, title, address, participate_num, total_num, contacts, phone, imgs, start_time, ",
            "end_time, create_time, create_by, update_tiem, update_by, content",
            "from activity_notice",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "noticeMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "participate_num", property = "participateNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "total_num", property = "totalNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "contacts", property = "contacts", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "imgs", property = "imgs", jdbcType = JdbcType.VARCHAR),
            @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_by", property = "createBy", jdbcType = JdbcType.INTEGER),
            @Result(column = "update_tiem", property = "updateTiem", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_by", property = "updateBy", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.LONGVARCHAR)
    })
    ActivityNotice selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @UpdateProvider(type = ActivityNoticeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ActivityNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @Update({
            "update activity_notice",
            "set title = #{title,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR},",
            "participate_num = #{participateNum,jdbcType=INTEGER},",
            "total_num = #{totalNum,jdbcType=INTEGER},",
            "contacts = #{contacts,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR},",
            "imgs = #{imgs,jdbcType=VARCHAR},",
            "start_time = #{startTime,jdbcType=TIMESTAMP},",
            "end_time = #{endTime,jdbcType=TIMESTAMP},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_by = #{createBy,jdbcType=INTEGER},",
            "update_tiem = #{updateTiem,jdbcType=TIMESTAMP},",
            "update_by = #{updateBy,jdbcType=INTEGER},",
            "content = #{content,jdbcType=LONGVARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ActivityNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    @Update({
            "update activity_notice",
            "set title = #{title,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR},",
            "participate_num = #{participateNum,jdbcType=INTEGER},",
            "total_num = #{totalNum,jdbcType=INTEGER},",
            "contacts = #{contacts,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR},",
            "imgs = #{imgs,jdbcType=VARCHAR},",
            "start_time = #{startTime,jdbcType=TIMESTAMP},",
            "end_time = #{endTime,jdbcType=TIMESTAMP},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_by = #{createBy,jdbcType=INTEGER},",
            "update_tiem = #{updateTiem,jdbcType=TIMESTAMP},",
            "update_by = #{updateBy,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ActivityNotice record);

    //查询所有活动公告的方法  
    @Select({
            "select",
            "id, title, address, participate_num, total_num, contacts, phone, imgs, start_time,type, ",
            "end_time, create_time, create_by, update_tiem, update_by, content",
            "from activity_notice where 1=1 and type=#{type} ",
    })
    @ResultMap("noticeMap")
    List<ActivityNotice> selectAllByType(@Param(value = "type") Integer type);

    @Select({
            "select",
            "id, title, address, participate_num, total_num, contacts, phone, imgs, start_time,type, ",
            "end_time, create_time, create_by, update_tiem, update_by, content",
            "from activity_notice",
    })
    @ResultMap("noticeMap")
    List<ActivityNotice> selectAll();


    //根据名称模糊查询
    @Select({
            "select",
            "id, title, address, participate_num, total_num, contacts, phone, imgs, start_time, ",
            "end_time, create_time, create_by, update_tiem, update_by, content",
            "from activity_notice",
            "where title LIKE concat ('%', #{title},'%')"
    })
    @ResultMap("noticeMap")
    List<ActivityNotice> selectByTitle(String title);

}