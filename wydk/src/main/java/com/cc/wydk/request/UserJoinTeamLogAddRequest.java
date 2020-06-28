package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户注册请求体")
public class UserJoinTeamLogAddRequest {


    @ApiModelProperty("唯一id")
    private Integer id;

    @NotNull(message = "团队id不能为空")
    private Integer volunteerTeamId;

    @ApiModelProperty("是否审核通过")
    private Integer isExamine;

}
