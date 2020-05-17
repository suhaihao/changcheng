package com.cc.wydk.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("文明课堂修改请求体")
public class CivilizedClassroomUpdateRequest {

    @ApiModelProperty("唯一标识")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

}
