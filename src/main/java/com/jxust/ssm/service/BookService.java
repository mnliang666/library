package com.jxust.ssm.service;

import com.jxust.ssm.pojo.Book;

import java.util.List;

public interface BookService {
    //以书名查询书籍
    List<Book> searchBooks(String bookName);
}
