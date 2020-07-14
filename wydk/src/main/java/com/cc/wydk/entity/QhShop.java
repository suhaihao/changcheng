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
@ApiModel("商家表")
@TableName("qh_shop")
public class QhShop {

  @ApiModelProperty("唯一id")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty("名称")
  @TableField(value = "shop_team")
  private String shopTeam;

  @ApiModelProperty("手机")
  @TableField(value = "shop_phone")
  private String shopPhone;

  @ApiModelProperty("密码")
  @TableField(value = "shop_pass")
  private String shopPass;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("创建时间")
  @TableField(value = "create_time")
  private LocalDateTime createTime;




}
