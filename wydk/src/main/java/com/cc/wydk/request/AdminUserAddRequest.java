package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("添加后台用户请求体")
public class AdminUserAddRequest {


    @NotNull(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String userName;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头图地址")
    private String headImg;

    @ApiModelProperty("级别")
    private Integer leave;

}
