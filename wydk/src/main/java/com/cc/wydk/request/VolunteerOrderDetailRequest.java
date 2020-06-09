package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("志愿者下单详情请求体")
public class VolunteerOrderDetailRequest {

    @NotNull(message = "id不能为空")
    @ApiModelProperty("唯一标识")
    private Integer id;

}
