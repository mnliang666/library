package com.jxust.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxust.ssm.pojo.BorrowShip;
import com.jxust.ssm.service.BorrowShipService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BorrowShipController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private BorrowShipService borrowShipService;

    /**
     * 借阅图书
     * @return 成功借阅则返回true
     */
    @RequestMapping("/borrow")
    @ResponseBody
    public boolean borrow(HttpServletRequest request) {
        Integer id = new Integer(request.getParameter("id"));
        Object email = request.getSession().getAttribute("email");
        return borrowShipService.borrowBooks(id, email.toString());
    }

    /**
     * 查询借阅的书籍
     * @return 返回借阅的书籍的集合
     */
    @RequestMapping("/show")
    @ResponseBody
    public JSONArray showBorrow(HttpServletRequest request) {
        Object email = request.getSession().getAttribute("email");
        List<BorrowShip> borrowShips = borrowShipService.searchBooks(email.toString());
        JSONArray json = new JSONArray();
        for (BorrowShip b : borrowShips) {
            JSONObject jo = new JSONObject();
            jo.put("id", b.getId());
            jo.put("title", b.getTitle());
            jo.put("author", b.getAuthor());
            jo.put("publisher", b.getPublisher());
            json.add(jo);
        }
        return json;
    }

    /**
     * 归还书籍
     * @return 成功归还返回true
     */
    @RequestMapping("/return")
    @ResponseBody
    public boolean returnBook(HttpServletRequest request) {
        Integer id = new Integer(request.getParameter("id"));
        System.out.println(id);
        Object email = request.getSession().getAttribute("email");
        return borrowShipService.returnBook(email.toString(), id);
    }
}
