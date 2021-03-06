package com.power.saas.service;

import com.power.saas.dao.DeskInfoDao;
import com.power.saas.entity.DeskInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>桌台信息表 DeskInfoServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class DeskInfoService {

    public final static Logger logger = LoggerFactory.getLogger(DeskInfoService.class);

    @Autowired
    private DeskInfoDao dao;

    @Transactional
    public int insert(DeskInfo record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(DeskInfo record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(DeskInfo record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public DeskInfo selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(DeskInfo record) {
        return dao.queryByCount(record);
    }

    public List<DeskInfo> queryByList(DeskInfo record) {
        return dao.queryByList(record);
    }
}
