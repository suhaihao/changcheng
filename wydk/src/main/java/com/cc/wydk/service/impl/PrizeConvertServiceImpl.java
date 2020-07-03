package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.PrizeConvertLog;
import com.cc.wydk.mapper.PrizeConvertMapper;
import com.cc.wydk.service.PrizeConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrizeConvertServiceImpl extends ServiceImpl<PrizeConvertMapper, PrizeConvertLog> implements PrizeConvertService {

    private final PrizeConvertMapper prizeConvertMapper;

    @Autowired
    public PrizeConvertServiceImpl(PrizeConvertMapper prizeConvertMapper) {
        this.prizeConvertMapper = prizeConvertMapper;
    }
}
