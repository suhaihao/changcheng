package com.cc.wydk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.request.CivilizedClassroomPageListRequest;

public interface CivilizedClassroomService extends IService<CivilizedClassroom> {


    /**
     * 分页获取文明课堂
     *
     * @param request
     * @return
     */
    IPage<CivilizedClassroom> getByPageList(CivilizedClassroomPageListRequest request);
}
