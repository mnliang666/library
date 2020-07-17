package com.jxust.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxust.ssm.pojo.Book;
import com.jxust.ssm.service.BookService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private BookService bookService;

    /**
     * 根据书的名称进行检索
     */
    @RequestMapping("/search")
    @ResponseBody
    public JSONArray search_books(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        List<Book> books = bookService.searchBooks(bookName);
        JSONArray json = new JSONArray();
        for (Book book : books) {
            JSONObject jo = new JSONObject();
            jo.put("id", book.getId());
            jo.put("title", book.getTitle());
            jo.put("author", book.getAuthor());
            jo.put("publisher", book.getPublisher());
            jo.put("remain", book.getRemain());
            json.add(jo);
        }
        HttpSession session = request.getSession();
        session.setAttribute("searchResult", json);
        return json;
    }

}
