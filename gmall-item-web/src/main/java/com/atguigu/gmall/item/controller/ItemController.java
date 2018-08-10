package com.atguigu.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.bean.SkuSaleAttrValue;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.bean.SpuSaleAttrValue;
import com.atguigu.gmall.service.SkuService;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {
    @Reference
    SkuService skuService;
    @Reference
    SpuService spuService;
    @RequestMapping("/{skuId}.html")
    public String index(@PathVariable("skuId") String skuId, ModelMap map){
        SkuInfo skuInfo = skuService.getSkuInfoBySkuId(skuId);
        map.put("skuInfo",skuInfo);
        String spuId = skuInfo.getSpuId();
        Map<String,String> paramMap  = new HashMap<String,String>();
        paramMap.put("skuId",skuId);
        paramMap.put("spuId",spuId);
        List<SpuSaleAttr> spuSaleAttrList= spuService.getSpuSaleAttrListCheckBySku(paramMap);
        map.put("spuSaleAttrListCheckBySku",spuSaleAttrList);
        List<SkuInfo> skuSaleAttrValueListBySpu = skuService.getSkuSaleAttrValueListBySpu(spuId);
        Map<String,String> skuInfoMap=new HashMap<String,String>();
        for (SkuInfo sku:skuSaleAttrValueListBySpu) {
            String v = sku.getId();
            String k = "";
            List<SkuSaleAttrValue> skuSaleAttrValueList = sku.getSkuSaleAttrValueList();
            for (SkuSaleAttrValue skuSaleAttrValue: skuSaleAttrValueList) {
                k = k + "|" + skuSaleAttrValue.getSaleAttrValueId();
            }
            skuInfoMap.put(k,v);
        }
        String skuJson = JSON.toJSONString(skuInfoMap);
        map.put("skuJson",skuJson);
        return "item";
    }
}
