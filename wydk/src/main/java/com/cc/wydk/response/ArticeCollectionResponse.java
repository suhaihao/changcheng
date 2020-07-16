package com.cc.wydk.response;

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
@ApiModel("收藏表返回体")
public class ArticeCollectionResponse {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("广告id")
    private Integer articeId;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("类型：0文明红榜；  1 文明黑帮 ； 2五小形式  ；3文明课堂  ；4 十大精品；")
    private Integer type;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("标题")
    private String title;


}
