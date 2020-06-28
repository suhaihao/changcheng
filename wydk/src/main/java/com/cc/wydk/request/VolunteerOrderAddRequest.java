package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("志愿者下单请求体")
public class VolunteerOrderAddRequest {


    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("连接")
    private String link;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("具体内容")
    private String content;

    @ApiModelProperty("是否审核通过")
    private Integer isExamine;


}
