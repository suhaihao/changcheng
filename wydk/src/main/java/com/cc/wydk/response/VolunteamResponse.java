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
@ApiModel("团队列表返回体")
public class VolunteamResponse {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("联系人")
    private String manager;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("服务次数")
    private Integer numberOfServices;

    @ApiModelProperty("服务时长")
    private Integer serviceDuration;

    @ApiModelProperty("团队logo")
    private String teamLogo;

    @ApiModelProperty("团队名称")
    private String teamName;

    @ApiModelProperty("队伍标语")
    private String teamSlogan;

    @ApiModelProperty("队伍介绍")
    private String teamIntro;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("总人数")
    private Integer teamCount;


}
