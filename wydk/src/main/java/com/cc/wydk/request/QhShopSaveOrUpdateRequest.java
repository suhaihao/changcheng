package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("商户详情请求体")
public class QhShopSaveOrUpdateRequest {

    @NotNull(message = "id不能为空")
    @ApiModelProperty("唯一id")
    private Integer id;


}
