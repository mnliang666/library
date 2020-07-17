package com.jxust.ssm.mapper;

import com.jxust.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //根据email查询密码
    User selectByEmail(@Param("email") String email);

    //插入新用户
    void insertNewUser(User user);

    //修改密码
    int updatePasswordByUsername(@Param("password") String newPassword, @Param("email") String email);
}
