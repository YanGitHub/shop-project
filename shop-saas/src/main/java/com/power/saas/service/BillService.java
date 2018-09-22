package com.power.saas.service;

import com.power.saas.dao.BillDao;
import com.power.saas.entity.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>开台单信息表 BillServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class BillService {

    public final static Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillDao dao;

    @Transactional
    public int insert(Bill record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(Bill record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(Bill record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public Bill selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(Bill record) {
        return dao.queryByCount(record);
    }

    public List<Bill> queryByList(Bill record) {
        return dao.queryByList(record);
    }

    public List<Bill> queryListOrderByTime(Bill record) {
        return dao.queryListOrderByTime(record);
    }
}
