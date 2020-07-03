package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("文章删除点赞请求体")
public class ArticeLikesDeleteRequest {

    @NotNull(message = "文章id不能为空")
    @ApiModelProperty("文章id")
    private Integer articeId;

    @NotNull(message = "类型id不能为空")
    @ApiModelProperty("类型id")
    private Integer type;

}
