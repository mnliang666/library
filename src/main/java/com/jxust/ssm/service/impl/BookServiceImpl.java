package com.jxust.ssm.service.impl;

import com.jxust.ssm.mapper.BookMapper;
import com.jxust.ssm.pojo.Book;
import com.jxust.ssm.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    /**
     * 以书籍名查询书籍
     *
     * @param bookName 书籍名称
     * @return 查询到的List集合
     */
    @Override
    public List<Book> searchBooks(String bookName) {
        return bookMapper.selectBookByTitle(bookName);
    }

}
