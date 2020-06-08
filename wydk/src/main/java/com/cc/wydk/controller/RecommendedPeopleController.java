package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.RecommendedPeople;
import com.cc.wydk.request.RecommendedPeoplePageListRequest;
import com.cc.wydk.service.RecommendedPeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


}
