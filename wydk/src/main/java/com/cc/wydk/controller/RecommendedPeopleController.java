package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.RecommendedPeople;
import com.cc.wydk.request.RecommendedPeopleDetailRequest;
import com.cc.wydk.request.RecommendedPeoplePageListRequest;
import com.cc.wydk.request.RecommendedPeopleSaveOrUpdateRequest;
import com.cc.wydk.service.RecommendedPeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recommend")
@CrossOrigin
@Api("全國好人")
public class RecommendedPeopleController {

    private final RecommendedPeopleService recommendedPeopleService;

    @Autowired
    public RecommendedPeopleController(RecommendedPeopleService recommendedPeopleService) {
        this.recommendedPeopleService = recommendedPeopleService;
    }

    @PostMapping("/getByPageList")
    @ApiOperation(value = "获取分頁列表")
    public IPage<RecommendedPeople> getByPageList(@RequestBody RecommendedPeoplePageListRequest request) {
        return recommendedPeopleService.getPageList(request);
    }

    @PostMapping("/getDetail")
    @ApiOperation(value = "获取详情")
    public RecommendedPeople getDetail(@RequestBody RecommendedPeopleDetailRequest request) {
        return recommendedPeopleService.getById(request.getId());
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除好人")
    public Boolean delRecommendedPeople(@RequestBody RecommendedPeopleDetailRequest request) {
        return recommendedPeopleService.removeById(request.getId());
    }

    @PostMapping("/updateOrSave")
    @ApiOperation(value = "添加更新好人")
    public Boolean updateOrSaveRecommendedPeople(@RequestBody RecommendedPeopleSaveOrUpdateRequest request) {
        RecommendedPeople recommendedPeople = new RecommendedPeople();
        BeanUtils.copyProperties(request, recommendedPeople);
        return recommendedPeopleService.saveOrUpdate(recommendedPeople);
    }

}
