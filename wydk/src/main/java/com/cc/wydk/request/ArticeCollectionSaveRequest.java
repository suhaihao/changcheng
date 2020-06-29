package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("收藏添加请求体")
public class ArticeCollectionSaveRequest {

    @ApiModelProperty("文章id")
    private Integer articeId;

    @NotNull(message = "各种文章类型不能为空")
    @ApiModelProperty("类型")
    private Integer type;

}
