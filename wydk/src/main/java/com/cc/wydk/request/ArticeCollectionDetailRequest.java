package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("收藏列表详情请求体")
public class ArticeCollectionDetailRequest {


    @NotNull(message = "请求id不能为空")
    @ApiModelProperty("id")
    private Integer id;


}
