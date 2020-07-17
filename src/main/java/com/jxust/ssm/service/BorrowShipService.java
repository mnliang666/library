package com.jxust.ssm.service;

import com.jxust.ssm.pojo.BorrowShip;

import java.util.List;

public interface BorrowShipService {
    //借阅书籍
    boolean borrowBooks(Integer id, String email);
    //查找用户借阅的书籍
    List<BorrowShip> searchBooks(String email);
    //归还书籍
    boolean returnBook(String email,Integer id);
}
