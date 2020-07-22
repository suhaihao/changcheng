package com.cc.wydk.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@ApiModel("商品添加修改请求体")
public class ProductSaveOrUpdateRequest {

    @ApiModelProperty("唯一id")
    private Integer id;

    @ApiModelProperty("名称")
    private String productName;

    @ApiModelProperty("类型")
    private Integer productType;

    @ApiModelProperty("积分")
    private Integer productInteger;

    @ApiModelProperty("图片")
    private String productImg;


}
