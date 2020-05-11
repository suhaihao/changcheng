package com.cc.wydk.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("activity_clock")
public class ActivityClock {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

}
