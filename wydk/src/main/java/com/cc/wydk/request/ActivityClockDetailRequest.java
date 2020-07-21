package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("打卡详情请求体")
public class ActivityClockDetailRequest {

    @NotNull(message = "id不能为空")
    @ApiModelProperty("打卡记录id")
    private Integer id;

    @NotNull(message = "审核状态不能为空")
    @ApiModelProperty("是否审核")
    private Integer isCheck;
}
