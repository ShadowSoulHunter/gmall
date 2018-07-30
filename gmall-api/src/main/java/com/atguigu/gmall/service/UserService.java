package com.atguigu.gmall.service;





import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> userInfoList();

    UserInfo getUserInfoById(String id);

    void deleteUserInfoById(String id);

    void updateUserInfo(UserInfo userInfo);
}
