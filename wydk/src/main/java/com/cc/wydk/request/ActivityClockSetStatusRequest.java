package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("设置用户当前状态请求体")
public class ActivityClockSetStatusRequest {

    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("状态0暂未签到1签到开始2签到结束")
    private String status;

}
