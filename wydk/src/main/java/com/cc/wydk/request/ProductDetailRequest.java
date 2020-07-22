package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("商品详情请求体")
public class ProductDetailRequest {

    @NotNull(message = "唯一id不能为空")
    @ApiModelProperty("id")
    private Integer id;

}
