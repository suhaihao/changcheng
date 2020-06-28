package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.UserJoinTemLog;
import com.cc.wydk.mapper.UserJoinTemLogMapper;
import com.cc.wydk.service.UserJoinTemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.hebeiwanteng.com
 *
 * @author 苏海
 * Package com.hebeiwanteng.ipc_shopping_server.response.advert
 * ClassName:AdvertPlanPageEntityResponse
 * Description:
 * Date 上午11:02 2020/6/8
 * Modify By :
 * Copyright: 2018 www.hebeiwanteng.com Inc. All rights reserved.
 * 注意：本内容仅限于河北万腾科技有限公司内部传阅，禁止外泄以及用于其他的商业目的.
 */
@Service
public class UserJoinTemLogServiceImpl extends ServiceImpl<UserJoinTemLogMapper, UserJoinTemLog> implements UserJoinTemLogService {

    private final UserJoinTemLogMapper userJoinTemLogMapper;

    @Autowired
    public UserJoinTemLogServiceImpl(UserJoinTemLogMapper userJoinTemLogMapper) {
        this.userJoinTemLogMapper = userJoinTemLogMapper;
    }



}
