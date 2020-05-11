package com.cc.wydk.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cc.wydk.mapper")
public class MybatisPlusConfig {

}