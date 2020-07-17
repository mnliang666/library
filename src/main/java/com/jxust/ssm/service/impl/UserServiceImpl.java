package com.jxust.ssm.service.impl;

import com.jxust.ssm.mapper.UserMapper;
import com.jxust.ssm.pojo.User;
import com.jxust.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 登录功能的实现，调用Mapper层的selectByEmail()方法
     *
     * @param email    用户的Email
     * @param password 用户密码
     * @return 两项匹配成功返回该用户的User对象
     */
    public User userLogin(String email, String password) {
        User user = userMapper.selectByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /**
     * 注册功能，注册新用户
     *
     * @param userName 名称
     * @param password 密码
     * @param email    邮箱
     * @return 注册成功返回true
     * 备注：邮箱的属性是unique的如果根据邮箱能查询到一个用户，证明该用户存在，返回false
     */
    public boolean userRegister(String userName, String password, String email) {
        if (userMapper.selectByEmail(email) != null) {
            return false;
        } else {
            User user = new User();
            user.setUsername(userName);
            user.setPassword(password);
            user.setEmail(email);
            userMapper.insertNewUser(user);
            return true;
        }
    }

    /**
     * 根据邮箱注册新用户，根据影响行数返回true/false
     *
     * @param newPassword 新密码
     * @param email       用户的邮箱
     * @return 修改成功返回true
     */
    public boolean updatePassword(String newPassword, String email) {
        return userMapper.updatePasswordByUsername(newPassword, email) == 1;
    }
}
