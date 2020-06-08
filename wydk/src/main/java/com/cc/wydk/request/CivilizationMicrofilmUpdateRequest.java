package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("微电影添加请求体")
public class CivilizationMicrofilmUpdateRequest {

    @ApiModelProperty("唯一标识")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("发表者")
    private String publishedBy;

    @ApiModelProperty("连接")
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
