package com.jxust.ssm.pojo;

/**
 * 借阅关系表，连表查询用户借阅了什么书时会用到此类
 *
 * id 为借阅的书籍的id
 * email 用户邮箱
 * title 书籍的名称
 * author 作者
 * publisher 书籍出版社
 */

public class BorrowShip {
    private Integer id;
    private String email;
    private String title;
    private String author;
    private String publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

}
