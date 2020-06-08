package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加留言请求体")
public class ActivityMessageRequest {


    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("头像")
    private String headImg;

    @ApiModelProperty("留言")
    private String message;

    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("用户id")
    private Integer userId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
