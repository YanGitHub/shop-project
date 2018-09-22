package com.power.saas.service;

import com.power.saas.dao.OrderDao;
import com.power.saas.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>销售统计表 OrderServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class OrderService {

    public final static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDao dao;

    @Transactional
    public int insert(Order record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(Order record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(Order record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public Order selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(Order record) {
        return dao.queryByCount(record);
    }

    public List<Order> queryByList(Order record) {
        return dao.queryByList(record);
    }
}
