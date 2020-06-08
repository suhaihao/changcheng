package com.cc.wydk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("全国十大好人")
@TableName("recommended_people")
public class RecommendedPeople {

  @ApiModelProperty("唯一id")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty("名称")
  @TableField(value = "name")
  private String name;

  @ApiModelProperty("点赞数")
  @TableField(value = "likes")
  private String likes;

  @ApiModelProperty("头像")
  @TableField(value = "head_img")
  private String headImg;

  @ApiModelProperty("地址")
  @TableField(value = "address")
  private String address;

  @ApiModelProperty("标题")
  @TableField(value = "title")
  private String title;

  @ApiModelProperty("内容")
  @TableField(value = "content")
  private String content;

  @ApiModelProperty("类型")
  @TableField(value = "type")
  private String type;

}
