package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("文章留言列表请求体")
public class ArticeMessagePageListRequest {

    @ApiModelProperty("页数")
    private int pageIndex = 1;

    @ApiModelProperty("分页大小")
    private int pageSize = 20;

    @ApiModelProperty("是否查看用户留言")
    private Boolean isUser=false;

    @ApiModelProperty("文章id")
    private Integer articeId;



}
