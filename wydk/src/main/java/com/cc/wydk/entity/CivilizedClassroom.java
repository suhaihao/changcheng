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
@EqualsAndHashCode()
@ApiModel("文明课堂")
@TableName("civilized_classroom")
public class CivilizedClassroom {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("类型")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty("标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty("连接")
    @TableField(value = "link")
    private String link;

    @ApiModelProperty("主图")
    @TableField(value = "imgs")
    private String imgs;

    @ApiModelProperty("点赞数")
    @TableField(value = "likes")
    private String likes;

    @ApiModelProperty("内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty("电影")
    @TableField(value = "video")
    private String video;

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
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    @TableField(value = "update_by")
    private Integer updateBy;


}
