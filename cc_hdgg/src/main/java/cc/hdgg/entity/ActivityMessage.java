package cc.hdgg.entity;

import java.util.Date;

public class ActivityMessage {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.id
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.name
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.head_img
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    private String headImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.message
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    private String message;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.activity_id
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    private Integer activityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.user_id
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity_message.create_time
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.id
     *
     * @return the value of activity_message.id
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.id
     *
     * @param id the value for activity_message.id
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.name
     *
     * @return the value of activity_message.name
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.name
     *
     * @param name the value for activity_message.name
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.head_img
     *
     * @return the value of activity_message.head_img
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.head_img
     *
     * @param headImg the value for activity_message.head_img
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.message
     *
     * @return the value of activity_message.message
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.message
     *
     * @param message the value for activity_message.message
     *
     * @mbg.generated Thu Apr 30 18:01:32 CST 2020
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.activity_id
     *
     * @return the value of activity_message.activity_id
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.activity_id
     *
     * @param activityId the value for activity_message.activity_id
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.user_id
     *
     * @return the value of activity_message.user_id
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.user_id
     *
     * @param userId the value for activity_message.user_id
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_message.create_time
     *
     * @return the value of activity_message.create_time
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_message.create_time
     *
     * @param createTime the value for activity_message.create_time
     *
     * @mbg.generated Thu Apr 30 18:01:33 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}