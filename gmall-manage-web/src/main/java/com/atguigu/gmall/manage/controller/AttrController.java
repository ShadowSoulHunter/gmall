package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseAttrInfo;
import com.atguigu.gmall.bean.BaseAttrValue;
import com.atguigu.gmall.service.AttrService;
import com.google.gson.Gson;
import org.assertj.core.util.Compatibility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AttrController {


    @Reference
    AttrService attrService;
    @ResponseBody
    @RequestMapping("getAttrList")
    public List<BaseAttrInfo> getAttrList(String catalog3Id){
        List<BaseAttrInfo> baseAttrInfoList= attrService.getAttrList(catalog3Id);
        return baseAttrInfoList;
    }

    @ResponseBody
    @RequestMapping("getAttrListByCtg3Id")
    public List<BaseAttrInfo> getAttrListByCtg3Id(String catalog3Id){
        List<BaseAttrInfo> baseAttrInfoList= attrService.getAttrListByCtg3Id(catalog3Id);
        return baseAttrInfoList;
    }

    @ResponseBody
    @RequestMapping("saveAttr")
    public String saveAttr(BaseAttrInfo baseAttrInfo){
        attrService.saveAttr(baseAttrInfo);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "removeAttr")
    public String removeAttr(String attrInfoId){
        System.out.println(attrInfoId);

        attrService.removeAttr(attrInfoId);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "getAttrValue")
    public  List<BaseAttrValue> getAttrValue(String attrId,Map<String,Object> map){
            List<BaseAttrValue> baseAttrValueList = attrService.getAttrValue(attrId);
            return  baseAttrValueList;
    }


    @ResponseBody
    @RequestMapping(value = "updateAttr")
    public String updateAttr(BaseAttrInfo baseAttrInfo){
        attrService.updateAttr(baseAttrInfo);
        return "success";
    }
}
