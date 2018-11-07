package com.qingbo.sell.controller;

import VO.ProductInfoVO;
import VO.ProductVO;
import VO.ResultVO;
import com.qingbo.sell.dataobject.ProductCategory;
import com.qingbo.sell.dataobject.ProductInfo;
import com.qingbo.sell.service.ProductCategoryService;
import com.qingbo.sell.service.ProductService;
import com.qingbo.sell.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("buyer/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    /**
     * 查询所有有效商品
     * 获取type列表
     */
    @GetMapping("/list")
    public ResultVO list() {

        //查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //获取type类目列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //从数据库查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory p : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(p.getCategoryName());
            productVO.setType(p.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(p.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultUtil.success(productVOList);
    }

    /**
     * 获取商品列表（）
     * @param productIds
     * @return
     */
    @GetMapping("/listForOrder")
    public List<ProductInfo> listForOrder(List<String> productIds){
        return null;
    }
}
