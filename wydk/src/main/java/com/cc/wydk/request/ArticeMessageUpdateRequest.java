package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("文章留言添加修改请求体")
public class ArticeMessageUpdateRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("详情")
    private String message;


    @ApiModelProperty("文章id")
    private Integer articeId;

    @NotNull(message = "类型：1文明红榜 2 文明黑帮 3 文明课堂 4十大精品 5五小形式 ")
    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("审核")
    private Integer isExamine;

}
