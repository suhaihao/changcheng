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

@ApiModel("活动表")
@TableName("rx_activity_notice")
public class ActivityNotice {

  @ApiModelProperty("唯一id")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty("标题")
  @TableField(value = "title")
  private String title;

  @ApiModelProperty("地址")
  @TableField(value = "address")
  private String address;

  @ApiModelProperty("参与人")
  @TableField(value = "participate_num")
  private Integer participateNum;

  @ApiModelProperty("总人数")
  @TableField(value = "total_num")
  private Integer totalNum;

  @ApiModelProperty("联系人")
  @TableField(value = "contacts")
  private String contacts;

  @ApiModelProperty("手机号")
  @TableField(value = "phone")
  private String phone;

  @ApiModelProperty("活动内容")
  @TableField(value = "content")
  private String content;

  @ApiModelProperty("活动图片")
  @TableField(value = "imgs")
  private String imgs;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("开始时间")
  @TableField(value = "start_time")
  private LocalDateTime startTime;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("开始时间")
  @TableField(value = "end_time")
  private LocalDateTime endTime;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("创建时间")
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  @ApiModelProperty("创建人")
  @TableField(value = "create_by")
  private Integer createBy;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("修改时间")
  @TableField(value = "update_tiem")
  private LocalDateTime updateTiem;

  @ApiModelProperty("修改人")
  @TableField(value = "update_by")
  private Integer updateBy;

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

  public Integer getParticipateNum() {
    return participateNum;
  }

  public void setParticipateNum(Integer participateNum) {
    this.participateNum = participateNum;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public String getContacts() {
    return contacts;
  }

  public void setContacts(String contacts) {
    this.contacts = contacts;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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
}
