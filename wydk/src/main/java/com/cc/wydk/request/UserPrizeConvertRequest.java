package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户奖品兑换请求体")
public class UserPrizeConvertRequest {

    @NotNull(message = "奖品名称不能为空")
    @ApiModelProperty("兑换积分名称")
    private String prizeName;

    @NotNull(message = "消耗积分不能为空")
    @ApiModelProperty("积分")
    private Integer integral;

    @NotNull(message = "兑奖手机号不能为空")
    @ApiModelProperty("手机号")
    private String phone;

    @NotNull(message = "商户id不能为空")
    @ApiModelProperty("商户id")
    private Integer shopId;

    @NotNull(message = "商户密码不能为空")
    @ApiModelProperty("商户密码")
    private String shopPass;

}
