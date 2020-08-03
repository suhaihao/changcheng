package com.cc.wydk.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("文明课堂录入请求体")
public class CivilizedClassroomAddRequest {

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("连接")
    private String link;

    @ApiModelProperty("主图")
    private String imgs;

    @ApiModelProperty("likes")
    private String likes;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("视频")
    private String video;


}
