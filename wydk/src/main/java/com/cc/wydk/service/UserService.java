package com.cc.wydk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * All rights Reserved, Designed By www.hebeiwanteng.com
 *
 * @author 苏海
 * Package com.hebeiwanteng.ipc_shopping_server.response.advert
 * ClassName:AdvertPlanPageEntityResponse
 * Description:
 * Date 上午11:01 2020/6/8
 * Modify By :
 * Copyright: 2018 www.hebeiwanteng.com Inc. All rights reserved.
 * 注意：本内容仅限于河北万腾科技有限公司内部传阅，禁止外泄以及用于其他的商业目的.
 */
public interface UserService extends IService<User>, UserDetailsService {
    /**
     * 根据名称获取唯一用户
     *
     * @param userName
     * @return
     */
    User loginByUserName(String userName);
}
