package com.power.saas.service;

import com.power.saas.dao.DeskTypeDao;
import com.power.saas.entity.DeskType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>桌台类型表 DeskTypeServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class DeskTypeService {

    public final static Logger logger = LoggerFactory.getLogger(DeskTypeService.class);

    @Autowired
    private DeskTypeDao dao;

    @Transactional
    public int insert(DeskType record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(DeskType record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(DeskType record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public DeskType selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(DeskType record) {
        return dao.queryByCount(record);
    }

    public List<DeskType> queryByList(DeskType record) {
        return dao.queryByList(record);
    }
}
