package com.cc.wydk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.request.ActivityClockGetStatusRequest;
import com.cc.wydk.request.ActivityClockSetStatusRequest;
import com.cc.wydk.request.ActivityClockSignInRequest;

public interface ActivityClockService extends IService<ActivityClock> {
    /**
     * 保存数据
     *
     * @param request
     * @return
     */
    Boolean saveActivityClock(ActivityClockSignInRequest request);


    /**
     * 查找用户是否参加过活动
     *
     * @param request
     * @return
     */
    Boolean getByActivityIdAndUserId(ActivityClockGetStatusRequest request);

    /**
     * 根据活动id用户id查询该用户的信息
     *
     * @param request
     * @return
     */
    ActivityClock getByUserIdAndActivityIdAndTime(ActivityClockGetStatusRequest request);

    /**
     * 根据用户活动状态记录
     *
     * @param request
     * @return
     */
    Boolean updateActivityClock(ActivityClockSetStatusRequest request);
}
