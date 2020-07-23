package com.cc.wydk.response;

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
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("打卡返回体")
@TableName("activity_clock")
public class ActivityClockResponse {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("活动id")
    @TableField(value = "activity_id")
    private Integer activityId;

    @ApiModelProperty("用户id")
    @TableField(value = "user_id")
    private Integer userId;

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
    @ApiModelProperty("结束时间")
    @TableField(value = "end_time")
    private LocalDateTime endTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("工作时长")
    @TableField(value = "duration")
    private String duration;

    @ApiModelProperty("状态0暂未签到1签到开始1签到结束")
    @TableField(value = "status")
    private String status;

    @ApiModelProperty("是否报名0没有1有")
    @TableField(value = "sign_up")
    private String signUp;

    @ApiModelProperty("经度")
    @TableField(value = "longitude")
    private Double longitude;

    @ApiModelProperty("纬度")
    @TableField(value = "latitude")
    private Double latitude;

    @ApiModelProperty("标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty("地址")
    @TableField(value = "address")
    private String address;

    @ApiModelProperty("活动图片")
    @TableField(value = "imgs")
    private String imgs;

    @ApiModelProperty("开始图片")
    @TableField(value = "start_photo")
    private String startPhoto;

    @ApiModelProperty("结束图片")
    @TableField(value = "end_photo")
    private String endPhoto;

}
