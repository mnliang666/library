package com.jxust.ssm.service;

import com.jxust.ssm.pojo.User;

public interface UserService {
    //登录
    User userLogin(String email, String password);
    //注册
    boolean userRegister(String userName, String password, String email);
    //修改密码
    boolean updatePassword(String newPassword, String email);
}
