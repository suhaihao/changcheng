package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.CivilizationMicrofilm;
import com.cc.wydk.entity.CivilizedClassroom;
import com.cc.wydk.request.*;
import com.cc.wydk.service.CivilizationMicrofilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/microfilm")
@CrossOrigin
@Api("文明微电影")
public class CivilizationMicrofilmController {

    private final CivilizationMicrofilmService civilizationMicrofilmService;

    @Autowired
    public CivilizationMicrofilmController(CivilizationMicrofilmService civilizationMicrofilmService) {
        this.civilizationMicrofilmService = civilizationMicrofilmService;
    }


    @PostMapping("/getByPageList")
    @ApiOperation(value = "分页获取文明课堂的数据")
    public IPage<CivilizationMicrofilm> getByPageList(@RequestBody CivilizationMicrofilmPageListRequest request) {
        return civilizationMicrofilmService.getByPageList(request);
    }


    @PostMapping("/saveCivilizationMicrofilm")
    @ApiOperation(value = "文明微电影数据添加")
    public Boolean saveCivilizationMicrofilm(@RequestBody CivilizationMicrofilmAddRequest request) {
        CivilizationMicrofilm civilizationMicrofilm = new CivilizationMicrofilm();
        BeanUtils.copyProperties(request, civilizationMicrofilm);
        civilizationMicrofilm.setCreateTime(LocalDateTime.now());
        civilizationMicrofilm.setUpdateTime(LocalDateTime.now());
        return civilizationMicrofilmService.save(civilizationMicrofilm);
    }

    @PostMapping("/updateCivilizationMicrofilm")
    @ApiOperation(value = "文明微电影数据修改")
    public Boolean updateCivilizationMicrofilm(@RequestBody CivilizationMicrofilmUpdateRequest request) {
        CivilizationMicrofilm civilizationMicrofilm = new CivilizationMicrofilm();
        BeanUtils.copyProperties(request, civilizationMicrofilm);
        return civilizationMicrofilmService.updateById(civilizationMicrofilm);
    }

}
