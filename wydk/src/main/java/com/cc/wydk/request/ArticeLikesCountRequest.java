package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("文章点赞总数请求体")
public class ArticeLikesCountRequest {

    @NotNull(message = "文章id不能为空")
    @ApiModelProperty("文章id")
    private Integer articeId;

}
