package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("五小形式详情请求体")
public class FiveFormDetailRequest {

    @NotNull(message = "唯一id不能为空")
    @ApiModelProperty("唯一id")
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
