package com.cc.wydk.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商户更新添加请求体")
public class QhShopDetailRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("名称")
    private String shopTeam;

    @ApiModelProperty("手机")
    private String shopPhone;

    @ApiModelProperty("密码")
    private String shopPass;


}
