package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("微电影详情请求体")
public class CivilizationMicrofilmDetailRequest {

    @NotNull(message = "唯一id不能为空")
    @ApiModelProperty("唯一标识")
    private Integer id;

}
