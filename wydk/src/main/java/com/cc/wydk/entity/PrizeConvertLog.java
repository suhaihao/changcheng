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
@ApiModel("奖品兑换记录")
@TableName("prize_convert_log")
public class PrizeConvertLog {

  @ApiModelProperty("唯一id")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty("兑换积分名称")
  @TableField(value = "prize_name")
  private String prizeName;

  @ApiModelProperty("积分")
  @TableField(value = "integral")
  private Integer integral;

  @ApiModelProperty("用户id")
  @TableField(value = "user_id")
  private Integer userId;

  @ApiModelProperty("手机号")
  @TableField(value = "phone")
  private String phone;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("创建时间")
  @TableField(value = "create_time")
  private LocalDateTime createTime;



}
