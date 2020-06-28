package com.cc.wydk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.AdminUser;

public interface AdminUserService extends IService<AdminUser> {

    /**
     * 根据用户名
     * @param userName
     * @return
     */
    AdminUser getByUserName(String userName);

}
