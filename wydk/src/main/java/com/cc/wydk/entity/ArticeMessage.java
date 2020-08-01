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
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@ApiModel("文章留言列表")
@TableName("artice_message")
public class ArticeMessage {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("详情")
    @TableField(value = "message")
    private String message;

    @ApiModelProperty("用户id")
    @TableField(value = "user_id")
    private Integer userId;

    @ApiModelProperty("文章id")
    @TableField(value = "artice_id")
    private Integer articeId;

    @ApiModelProperty("类型：1文明红榜 2 文明黑帮 3 文明课堂 4十大精品 5五小形式 ")
    @TableField(value = "type")
    private Integer type;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("审核标志")
    @TableField(value = "is_examine")
    private Integer isExamine;



}
