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
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@ApiModel("十大精品")
@TableName("ten_products")
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
  @ApiModelProperty("开始时间")
  @TableField(value = "start_Time")
  private LocalDateTime startTime;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("结束时间")
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


}
