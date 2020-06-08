package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("五小形式表添加更新请求体")
public class FiveFormAddOrUpdateRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("图片地址")
    private String imgs;

    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("连接地址")
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
