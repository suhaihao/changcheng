package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ActivityClock;
import com.cc.wydk.entity.ActivityNotice;
import com.cc.wydk.entity.User;
import com.cc.wydk.request.*;

import java.util.List;

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

    /**
     * 分页获取活动参与人
     *
     * @param request
     * @return
     */
    IPage<User> getPageClockList(ActivityClockPageListRequest request);

    /**
     * 分页获取当前用户参与的活动
     *
     * @param request
     * @return
     */
    List<ActivityNotice> getPageNoticeList(ActivityNoticePageListRequest request);
}
