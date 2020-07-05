package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户奖品详情请求体")
public class UserPrizeConvertDetailRequest {

    @NotNull(message = "详情id不能为空")
    @ApiModelProperty("id")
    private Integer id;


}
