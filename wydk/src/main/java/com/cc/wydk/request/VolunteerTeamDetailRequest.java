package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("团队详情请求体")
public class VolunteerTeamDetailRequest {

    @ApiModelProperty("团队id")
    private Integer id;


}
