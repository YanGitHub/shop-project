package com.power.saas.service;

import com.power.saas.dao.DeskStatusDao;
import com.power.saas.entity.DeskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>桌台状态表 DeskStatusServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class DeskStatusService {

    public final static Logger logger = LoggerFactory.getLogger(DeskStatusService.class);

    @Autowired
    private DeskStatusDao dao;

    @Transactional
    public int insert(DeskStatus record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(DeskStatus record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(DeskStatus record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public DeskStatus selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(DeskStatus record) {
        return dao.queryByCount(record);
    }

    public List<DeskStatus> queryByList(DeskStatus record) {
        return dao.queryByList(record);
    }
}
