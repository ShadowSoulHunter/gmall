package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.manage.util.MyUploadUtil;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class SpuController {
    @Reference
    SpuService spuService;


    @ResponseBody
    @RequestMapping("getSpuImageListBySpuId")
    public List<SpuImage> getSpuImageListBySpuId(String spuId) {
        List<SpuImage> spuImageList = spuService.getSpuImageListBySpuId(spuId);
        return spuImageList;
    }

    @ResponseBody
    @RequestMapping("getSpuSaleAttrListBySpuId")
    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId) {
        List<SpuSaleAttr> spuSaleAttrList = spuService.getSpuSaleAttrListBySpuId(spuId);
        return spuSaleAttrList;
    }

    @ResponseBody
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file")MultipartFile file) {
        String imgUrl = MyUploadUtil.uploadImage(file);
        return imgUrl;
    }
    @ResponseBody
    @RequestMapping("getSpuList")
    public List<SpuInfo> getSpuList(String catalog3Id) {
        List<SpuInfo> spuInfoList= spuService.getAttrList(catalog3Id);
        return spuInfoList;
    }


    @ResponseBody
    @RequestMapping("baseSaleAttrList")
    public List<BaseSaleAttr> baseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrList = spuService.baseSaleAttrList();
        return baseSaleAttrList;
    }

    @ResponseBody
    @RequestMapping("saveSpu")
    public String saveSpu(SpuInfo spuinfo) {
        spuService.saveSpu(spuinfo);
        return "success";
    }

}
