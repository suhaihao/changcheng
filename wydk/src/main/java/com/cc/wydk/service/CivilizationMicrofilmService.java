package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.CivilizationMicrofilm;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.request.CivilizationMicrofilmPageListRequest;
import com.cc.wydk.request.CivilizedClassroomPageListRequest;

public interface CivilizationMicrofilmService extends IService<CivilizationMicrofilm> {


    /**
     * 分页获取文明课堂
     *
     * @param request
     * @return
     */
    IPage<CivilizationMicrofilm> getByPageList(CivilizationMicrofilmPageListRequest request);
}
