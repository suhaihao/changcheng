package com.cc.wydk.respond;

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
@ApiModel("用户表详情返回体")
public class UserResPonse {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("姓名")
    private String fullname;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("身份证")
    @TableField(value = "id_number")
    private Long idNumber;

    @ApiModelProperty("政治面貌")
    @TableField(value = "political_outlook")
    private String politicalOutlook;

    @ApiModelProperty("工作单位")
    @TableField(value = "work_unit")
    private String workUnit;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("生日")
    private LocalDateTime bornDate;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年龄")
    private String grade;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("头像")
    private String headImg;

    @ApiModelProperty("积分")
    private Integer integral;

    @ApiModelProperty("队伍id")
    private String team;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private Integer createBy;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    private Integer updateBy;

    @ApiModelProperty("点单次数")
    private Integer OrderCount;

    @ApiModelProperty("活动打开次数")
    private Integer activitySignCount;


}
