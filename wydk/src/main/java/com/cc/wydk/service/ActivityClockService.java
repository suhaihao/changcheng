package com.cc.wydk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.request.ActivityClockGetStatusRequest;
import com.cc.wydk.request.ActivityClockSignInRequest;

public interface ActivityClockService extends IService<ActivityClock> {
    /**
     * 保存数据
     * @param request
     * @return
     */
    Boolean saveActivityClock(ActivityClockSignInRequest request);

    /**
     * 根据活动id用户id查询该用户的信息
     * @param request
     * @return
     */
    ActivityClock getByUserIdAndActivityId(ActivityClockGetStatusRequest request);
}
