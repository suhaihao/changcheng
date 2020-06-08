package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.FiveForm;
import com.cc.wydk.request.FiveFormPageListRequest;

public interface FiveFormService extends IService<FiveForm> {

    /**
     * 分页获取列表信息
     *
     * @param request
     * @return
     */
    IPage<FiveForm> getPageList(FiveFormPageListRequest request);
}
