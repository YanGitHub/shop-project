package com.power.saas.service;

import com.power.saas.dao.VipTypeDao;
import com.power.saas.entity.VipType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>会员类型表 VipTypeServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class VipTypeService {

    public final static Logger logger = LoggerFactory.getLogger(VipTypeService.class);

    @Autowired
    private VipTypeDao dao;

    @Transactional
    public int insert(VipType record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(VipType record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(VipType record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public VipType selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(VipType record) {
        return dao.queryByCount(record);
    }

    public List<VipType> queryByList(VipType record) {
        return dao.queryByList(record);
    }

    public void create(VipType vipType) {
        dao.insert(vipType);
    }
}
