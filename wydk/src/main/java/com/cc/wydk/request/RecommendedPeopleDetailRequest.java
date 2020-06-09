package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("好人详情请求体")
public class RecommendedPeopleDetailRequest {

    @NotNull(message = "唯一id不能为空")
    @ApiModelProperty("唯一id")
    private Integer id;


}
