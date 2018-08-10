package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;

import java.util.List;
import java.util.Map;

public interface SpuService {
    List<SpuInfo> getAttrList(String catalog3Id);


     List<BaseSaleAttr> baseSaleAttrList();

    void saveSpu(SpuInfo spuinfo);

    List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);

    List<SpuImage> getSpuImageListBySpuId(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(Map<String, String> paramMap);
}
