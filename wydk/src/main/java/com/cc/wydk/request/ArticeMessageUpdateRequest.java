package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel("文章留言添加修改请求体")
public class ArticeMessageUpdateRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("详情")
    private String message;


    @ApiModelProperty("文章id")
    private Integer articeId;


}
