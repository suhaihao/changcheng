package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("文章列表请求体")
public class ArticePageListRequest {

    @ApiModelProperty("页数")
    private int pageIndex = 1;

    @ApiModelProperty("分页大小")
    private int pageSize = 20;

    @ApiModelProperty("类型：1 十大精品 ； 2五小形式  ；3 红黑榜 4 文明课堂  5志愿风采")
    private Integer type;

    @ApiModelProperty("类型id")
    private Integer typeId;


}
