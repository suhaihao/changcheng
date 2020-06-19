package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("文章列表修改请求体")
public class ArticeUpdateRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("标题展示类型")
    private String typeName;

    @ApiModelProperty("浏览量")
    private Integer views;

    @ApiModelProperty("类型：1 十大精品 ； 2五小形式  ；3 红黑榜 4 文明课堂  5志愿风采")
    private Integer type;

    @ApiModelProperty("类型id")
    private Integer typeId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("图片")
    private String imgs;

    @ApiModelProperty("图片名称")
    private String imgName;

}
