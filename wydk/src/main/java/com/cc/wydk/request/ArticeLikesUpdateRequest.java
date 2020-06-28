package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("文章点赞添加修改请求体")
public class ArticeLikesUpdateRequest {

    @NotNull(message = "广告id不能为空")
    @ApiModelProperty("广告id")
    private Integer articeId;

}
