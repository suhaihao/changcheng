package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("微电影修改请求体")
public class CivilizationMicrofilmUpdateRequest {

    @ApiModelProperty("唯一标识")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("发表者")
    private String publishedBy;

    @ApiModelProperty("连接")
    private String link;

    @ApiModelProperty("图片")
    private String img;
}
