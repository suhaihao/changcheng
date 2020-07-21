package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @ApiModelProperty("精度")
    @TableField(value = "longitude")
    private Double longitude;

    @ApiModelProperty("纬度")
    @TableField(value = "latitude")
    private Double latitude;

    @ApiModelProperty("开始照片")
    private String startPhoto;

    @ApiModelProperty("结束照片")
    private String endPhoto;

}
