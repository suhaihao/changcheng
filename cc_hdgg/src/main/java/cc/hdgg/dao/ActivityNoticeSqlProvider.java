package cc.hdgg.dao;

import cc.hdgg.entity.ActivityNotice;
import org.apache.ibatis.jdbc.SQL;

public class ActivityNoticeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    public String insertSelective(ActivityNotice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("activity_notice");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getParticipateNum() != null) {
            sql.VALUES("participate_num", "#{participateNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalNum() != null) {
            sql.VALUES("total_num", "#{totalNum,jdbcType=INTEGER}");
        }
        
        if (record.getContacts() != null) {
            sql.VALUES("contacts", "#{contacts,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            sql.VALUES("imgs", "#{imgs,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTiem() != null) {
            sql.VALUES("update_tiem", "#{updateTiem,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity_notice
     *
     * @mbg.generated Wed Apr 29 11:06:32 CST 2020
     */
    public String updateByPrimaryKeySelective(ActivityNotice record) {
        SQL sql = new SQL();
        sql.UPDATE("activity_notice");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getParticipateNum() != null) {
            sql.SET("participate_num = #{participateNum,jdbcType=INTEGER}");
        }
        
        if (record.getTotalNum() != null) {
            sql.SET("total_num = #{totalNum,jdbcType=INTEGER}");
        }
        
        if (record.getContacts() != null) {
            sql.SET("contacts = #{contacts,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getImgs() != null) {
            sql.SET("imgs = #{imgs,jdbcType=VARCHAR}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTiem() != null) {
            sql.SET("update_tiem = #{updateTiem,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}