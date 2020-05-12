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

    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "start_time")
    private LocaDateTime startTime;

    @Column(name = "end_time")
    private LocaDateTime endTime;

    @Column(name = "update_time")
    private LocaDateTime updateTime;

    @Column(name = "create_time")
    private LocaDateTime createTime;

    @Column(name = "duration")
    private String duration;

    @Column(name = "status")
    private String status;

    @Column(name = "sign_up")
    private String signUp;


}
