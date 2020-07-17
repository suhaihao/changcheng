package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("好人添加删除请求体")
public class RecommendedPeopleSaveOrUpdateRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("点赞数")
    private String likes;

    @ApiModelProperty("头像")
    private String headImg;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("类型")
    private String type;

}
