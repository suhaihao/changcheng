package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel("团队添加修改请求体")
public class VolunteerTeamSaveOrUpdateRequest {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("联系人")
    private String manager;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("团队logo")
    private String teamLogo;

    @ApiModelProperty("团队名称")
    private String teamName;

    @ApiModelProperty("队伍标语")
    private String teamSlogan;

    @ApiModelProperty("队伍介绍")
    private String teamIntro;


}
