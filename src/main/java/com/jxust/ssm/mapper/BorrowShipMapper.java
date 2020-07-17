package com.jxust.ssm.mapper;

import com.jxust.ssm.pojo.BorrowShip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowShipMapper {
    //通过id借阅书籍
    int borrowBookById(BorrowShip borrowShip);

    //如果成功借阅则让book表中的剩余数量减一
    int reduceBook(@Param("id") Integer id);


    //通过邮箱查找借阅的书籍
    List<BorrowShip> selectBookByEmail(@Param("email") String email);


    //归还书籍
    int returnBookByEmailAndId(BorrowShip borrowShip);

    //如果成功借阅则让book表中的剩余数量加一
    int returnBook(@Param("id") Integer id);


}