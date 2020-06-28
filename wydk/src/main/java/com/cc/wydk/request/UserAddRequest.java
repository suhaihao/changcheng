package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户注册请求体")
public class UserAddRequest {

    @NotNull(message = "手机号不能为空")
    @ApiModelProperty("手机号")
    private String phone;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    @NotNull(message = "姓名不能为空")
    @ApiModelProperty("姓名")
    private String fullname;

}
