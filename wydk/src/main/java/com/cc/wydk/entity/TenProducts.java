package com.cc.wydk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ApiModel("十大精品")
@TableName("rx_ten_products")
public class TenProducts {

  @ApiModelProperty("唯一id")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty("标题")
  @TableField(value = "title")
  private String title;

  @ApiModelProperty("地址")
  @TableField(value = "address")
  private String address;

  @ApiModelProperty("内容")
  @TableField(value = "content")
  private String content;

  @ApiModelProperty("图片地址")
  @TableField(value = "imgs")
  private String imgs;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("修改时间")
  @TableField(value = "start_Time")
  private LocalDateTime startTime;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("修改时间")
  @TableField(value = "end_Time")
  private LocalDateTime endTime;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("修改时间")
  @TableField(value = "create_Time")
  private LocalDateTime createTime;

  @ApiModelProperty("创建人")
  @TableField(value = "create_by")
  private Integer createBy;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("修改时间")
  @TableField(value = "update_Tiem")
  private LocalDateTime updateTiem;

  @ApiModelProperty("修改人")
  @TableField(value = "update_by")
  private Integer updateBy;

  @ApiModelProperty("类型")
  @TableField(value = "type")
  private Integer type;

  @ApiModelProperty("连接地址")
  @TableField(value = "link")
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

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public Integer getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Integer createBy) {
    this.createBy = createBy;
  }

  public LocalDateTime getUpdateTiem() {
    return updateTiem;
  }

  public void setUpdateTiem(LocalDateTime updateTiem) {
    this.updateTiem = updateTiem;
  }

  public Integer getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Integer updateBy) {
    this.updateBy = updateBy;
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
