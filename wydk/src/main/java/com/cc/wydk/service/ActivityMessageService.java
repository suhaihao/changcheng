package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.ActivityMessage;
import com.cc.wydk.request.ActivityMessagePageListRequest;

public interface ActivityMessageService extends IService<ActivityMessage> {

    /**
     * 分页获取列表信息
     *
     * @param request
     * @return
     */
    IPage<ActivityMessage> getPageList(ActivityMessagePageListRequest request);
}
