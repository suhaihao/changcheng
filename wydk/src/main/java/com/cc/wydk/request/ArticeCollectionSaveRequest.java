package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("收藏添加请求体")
public class ArticeCollectionSaveRequest {

    @ApiModelProperty("文章id")
    private Integer articeId;


}
