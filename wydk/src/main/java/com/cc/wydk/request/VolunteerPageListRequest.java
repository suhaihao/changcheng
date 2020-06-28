package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.chrono.IsoChronology;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("获取支援点单记录分页查询")
public class VolunteerPageListRequest {

    @ApiModelProperty("页数")
    private int pageIndex = 1;

    @ApiModelProperty("分页大小")
    private int pageSize = 20;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("是否过审0未过审1已过审")
    private Integer isExamine;

    @ApiModelProperty("我的接单")
    private Boolean IsUser;

    @ApiModelProperty("我的点单")
    private Boolean createBy;


}
