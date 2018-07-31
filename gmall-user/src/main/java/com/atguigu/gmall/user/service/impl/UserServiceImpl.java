package com.atguigu.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> userInfoList() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return  userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteUserInfoById(String id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKey(userInfo);
    }
}
