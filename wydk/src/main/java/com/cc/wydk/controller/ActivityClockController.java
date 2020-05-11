package com.cc.wydk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clock")
public class ActivityClockController {

    @GetMapping("/list")
    public String getByPageList() {

        return "测试";
    }

}
