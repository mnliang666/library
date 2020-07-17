package com.jxust.ssm.service.impl;

import com.jxust.ssm.mapper.BorrowShipMapper;
import com.jxust.ssm.pojo.BorrowShip;
import com.jxust.ssm.service.BorrowShipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BorrowShipServiceImpl implements BorrowShipService {
    @Resource
    private BorrowShipMapper borrowShipMapper;

    /**
     * 借阅书籍
     *
     * @param id    书籍id
     * @param email 邮箱
     * @return 借阅成功返回true
     */
    @Override
    public boolean borrowBooks(Integer id, String email) {
        BorrowShip borrowShip = new BorrowShip();
        borrowShip.setId(id);
        borrowShip.setEmail(email);
        if (borrowShipMapper.borrowBookById(borrowShip) == 1) {
            return borrowShipMapper.reduceBook(borrowShip.getId()) == 1;
        }
        return false;
    }

    /**
     * 查找借阅的书籍
     *
     * @param email 根据用户邮箱继续宁查询
     * @return 返回BorrowShip集合
     */
    @Override
    public List<BorrowShip> searchBooks(String email) {
        return borrowShipMapper.selectBookByEmail(email);
    }

    /**
     * 归还书籍
     *
     * @param email 用户邮箱
     * @param id    书籍id
     * @return true/false
     */
    @Override
    public boolean returnBook(String email, Integer id) {
        BorrowShip borrowShip = new BorrowShip();
        borrowShip.setEmail(email);
        borrowShip.setId(id);
        if (borrowShipMapper.returnBookByEmailAndId(borrowShip) > 0) {
            return borrowShipMapper.returnBook(id) == 1;
        }
        return false;
    }

}
