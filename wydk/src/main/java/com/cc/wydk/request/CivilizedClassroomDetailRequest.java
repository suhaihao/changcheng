package com.cc.wydk.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("文明课堂详情请求体")
public class CivilizedClassroomDetailRequest {

    @ApiModelProperty("唯一标识")
    @NotNull(message = "唯一id不能为空")
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
