package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.entity.User;
import com.cc.wydk.entity.VolunteerOrder;
import com.cc.wydk.request.*;
import com.cc.wydk.service.CivilizedClassroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/updateCivilizedClassroom")
    @ApiOperation(value = "文明课堂数据修改")
    public Boolean updateCivilizedClassroom(@RequestBody CivilizedClassroomUpdateRequest request) {
        CivilizedClassroom civilizedClassroom = new CivilizedClassroom();
        BeanUtils.copyProperties(request, civilizedClassroom);
        return civilizedClassroomService.updateById(civilizedClassroom);
    }

    @PostMapping("/getDeatil")
    @ApiOperation(value = "文明课堂详情")
    public CivilizedClassroom getDetail(@Valid @RequestBody CivilizedClassroomDetailRequest request) {
        return civilizedClassroomService.getById(request.getId());
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除文明课堂")
    public Boolean delCivilizedClassroom(@Valid @RequestBody CivilizedClassroomDetailRequest request) {
        return civilizedClassroomService.removeById(request.getId());
    }

}
