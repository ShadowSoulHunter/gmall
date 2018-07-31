package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
    @Reference
    UserService userService;

    @RequestMapping("/userInfoList")
    public ResponseEntity<List<UserInfo>> userInfoList(){
        List<UserInfo> userInfoList = userService.userInfoList();
        return ResponseEntity.ok(userInfoList);
    }

    @RequestMapping("/getUserInfoById/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") String id){
        UserInfo userInfo = userService.getUserInfoById(id);
        return userInfo;
    }

    @RequestMapping("/deleteUserInfoById/{id}")
    public void deleteUserInfoById(@PathVariable("id") String id){
        userService.deleteUserInfoById(id);
    }

    @RequestMapping("/updateUserInfo")
    public void updateUserInfo( String loginName,String id ){
       UserInfo userInfo =  userService.getUserInfoById(id);
       userInfo.setLoginName(loginName);
        userService.updateUserInfo(userInfo);
    }
}
