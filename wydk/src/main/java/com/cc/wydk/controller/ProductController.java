package com.cc.wydk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cc.wydk.entity.Product;
import com.cc.wydk.entity.VolunteerTeam;
import com.cc.wydk.exception.BusinessInterfaceException;
import com.cc.wydk.request.*;
import com.cc.wydk.respond.VolunteerTeamResponse;
import com.cc.wydk.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin
@Api("商品接口")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/getByPageList")
    @ApiOperation(value = "获取商品列表")
    public IPage<Product> getByRankingPageList(@RequestBody ProductPageListRequest request) {
        return productService.getPageList(request);
    }

    @PostMapping("/getDetail")
    @ApiOperation(value = "商品详情")
    public Product getDetail(@Valid @RequestBody ProductDetailRequest request) {
        return productService.getById(request);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除商品")
    public Boolean delVolunteerTeam(@Valid @RequestBody ProductDetailRequest request) {
        Product product = productService.getById(request);
        if (null == product) {
            throw new BusinessInterfaceException("商品不存在");
        }
        product.setIsDelete(1);
        return productService.updateById(product);
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "添加更新商品")
    public Boolean saveOrUpdateVolunteerTeam(@RequestBody ProductSaveOrUpdateRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        if (null == product.getId()) {
            product.setCreateTime(LocalDateTime.now());
        }
        return productService.saveOrUpdate(product);
    }


}
