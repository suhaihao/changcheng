package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("活动报名请求体")
public class ActivityClockSignInRequest {

    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("工作时长")
    private String duration;

    @ApiModelProperty("状态0暂未签到1签到开始1签到结束")
    private String status;

    @ApiModelProperty("是否报名0没有1有")
    private String signUp;


}
