package com.power.saas.service;

import com.power.saas.dao.BillMenuDao;
import com.power.saas.entity.BillMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>点菜信息表 BillMenuServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class BillMenuService {

    @Autowired
    private BillMenuDao dao;

    @Transactional
    public int insert(BillMenu record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(BillMenu record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(BillMenu record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public BillMenu selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(BillMenu record) {
        return dao.queryByCount(record);
    }

    public List<BillMenu> queryByList(BillMenu record) {
        return dao.queryByList(record);
    }
}
