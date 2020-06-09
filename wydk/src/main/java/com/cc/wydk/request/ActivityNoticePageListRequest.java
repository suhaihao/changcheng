package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("分页获取用户参加过的活动")
public class ActivityNoticePageListRequest {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("状态")
    private String status;
}
