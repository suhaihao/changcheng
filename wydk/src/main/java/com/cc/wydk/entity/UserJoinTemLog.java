package com.cc.wydk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户加入团队申请表")
@TableName("user_join_tem_log")
public class UserJoinTemLog {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField(value = "user_id")
    private Integer userId;

    @ApiModelProperty("团队id")
    @TableField(value = "volunteer_team_id")
    private Integer volunteerTeamId;

    @ApiModelProperty("是否审核通过")
    @TableField(value = "is_examine")
    private Integer isExamine;


}
