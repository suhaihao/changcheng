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
@ApiModel("黑榜")
@TableName("black_list")
public class BlackList {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty("图片")
    @TableField(value = "img")
    private String img;

    @ApiModelProperty("内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty("链接")
    @TableField(value = "link")
    private String link;

    @ApiModelProperty("地址")
    @TableField(value = "address")
    private String address;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    @TableField(value = "create_Time")
    private LocalDateTime createTime;

    @ApiModelProperty("创建者")
    @TableField(value = "create_by")
    private Integer createBy;

    @ApiModelProperty("点赞数")
    @TableField(value = "likes")
    private Integer likes;

    @ApiModelProperty("是否审核")
    @TableField(value = "is_examine")
    private Integer isExamine;


}
