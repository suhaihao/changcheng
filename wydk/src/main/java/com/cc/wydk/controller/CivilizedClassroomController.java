package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.request.CivilizedClassroomAddRequest;
import com.cc.wydk.request.CivilizedClassroomPageListRequest;
import com.cc.wydk.request.VolunteerOrderAddRequest;
import com.cc.wydk.request.VolunteerPageListRequest;
import com.cc.wydk.service.CivilizedClassroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/classroom")
@CrossOrigin
@Api("文明课堂")
public class CivilizedClassroomController {

    private final CivilizedClassroomService civilizedClassroomService;

    @Autowired
    public CivilizedClassroomController(CivilizedClassroomService civilizedClassroomService) {
        this.civilizedClassroomService = civilizedClassroomService;
    }


    @PostMapping("/getByPageList")
    @ApiOperation(value = "分页获取文明课堂的数据")
    public IPage<CivilizedClassroom> getByPageList(@RequestBody CivilizedClassroomPageListRequest request) {
        return civilizedClassroomService.getByPageList(request);
    }


    @PostMapping("/saveCivilizedClassroom")
    @ApiOperation(value = "文明课堂数据添加")
    public Boolean saveVolunteerOrder(@RequestBody CivilizedClassroomAddRequest request) {
        CivilizedClassroom civilizedClassroom = new CivilizedClassroom();
        BeanUtils.copyProperties(request, civilizedClassroom);
        civilizedClassroom.setCreateTime(LocalDateTime.now());
        civilizedClassroom.setUpdateTime(LocalDateTime.now());
        return civilizedClassroomService.save(civilizedClassroom);
    }

}
