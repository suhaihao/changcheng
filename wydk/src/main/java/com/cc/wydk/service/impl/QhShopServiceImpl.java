package com.cc.wydk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wydk.entity.QhShop;
import com.cc.wydk.mapper.QhshopMapper;
import com.cc.wydk.service.QhShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QhShopServiceImpl extends ServiceImpl<QhshopMapper, QhShop> implements QhShopService {

    private final QhshopMapper qhshopMapper;


    @Autowired
    public QhShopServiceImpl(QhshopMapper qhshopMapper) {
        this.qhshopMapper = qhshopMapper;
    }


}
