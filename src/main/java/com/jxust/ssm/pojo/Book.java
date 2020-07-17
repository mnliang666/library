package com.jxust.ssm.pojo;

/**
 * 书籍表
 *
 * id 书籍的id，数据库中为主键
 * title 书籍的名称
 * author 作者
 * publisher 书籍出版社
 * remain 库存(剩余多少数量可借)
 */

public class Book {

    private Integer id;

    private String title;

    private String author;

    private String publisher;

    private Integer remain;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }


    public Integer getRemain() {
        return remain;
    }

}
