package com.jxust.ssm.mapper;

import com.jxust.ssm.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    //以书名查询书籍
    List<Book> selectBookByTitle(@Param("title") String title);
}
