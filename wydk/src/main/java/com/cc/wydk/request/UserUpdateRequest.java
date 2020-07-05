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
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@ApiModel("用户修改请求体")
public class UserUpdateRequest {

    @NotNull(message = "唯一id不能为空")
    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("姓名")
    private String fullname;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("身份证")
    private Integer idNumber;

    @ApiModelProperty("政治面貌")
    private String politicalOutlook;

    @ApiModelProperty("工作单位")
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

    @ApiModelProperty("密码")
    private String password;

}
