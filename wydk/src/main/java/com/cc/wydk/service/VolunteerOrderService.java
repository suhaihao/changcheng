package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.request.VolunteerPageListRequest;

public interface VolunteerOrderService extends IService<VolunteerOrder> {
    /**
     * 分页获取点单记录
     *
     * @param request
     * @return
     */
    IPage<VolunteerOrder> getByPageList(VolunteerPageListRequest request);

    /**
     * 点单用户分页信息记录
     *
     * @param request
     * @return
     */
    IPage<User> getByPageUserList(VolunteerPageListRequest request);

    /**
     * 根据用户id 获取相应数据
     * @param userId
     * @return
     */
    Integer getCount(Integer userId);
}
