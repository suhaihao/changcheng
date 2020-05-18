package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("十大精品添加或修改请求体")
public class TenProductsAddOrUpdateRequest {

  @ApiModelProperty("唯一id")
  private Integer id;

  @ApiModelProperty("标题")
  private String title;

  @ApiModelProperty("地址")
  private String address;

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
