package com.atguigu.gmall.list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("list")
    public String list(){
        return "list";
    }
}
