package com.power.saas.service;

import com.power.saas.dao.VipInfoDao;
import com.power.saas.entity.VipInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>会员信息表 VipInfoServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class VipInfoService {

    public final static Logger logger = LoggerFactory.getLogger(VipInfoService.class);

    @Autowired
    private VipInfoDao dao;

    @Transactional
    public int insert(VipInfo record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(VipInfo record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(VipInfo record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public VipInfo selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(VipInfo record) {
        return dao.queryByCount(record);
    }

    public List<VipInfo> queryByList(VipInfo record) {
        return dao.queryByList(record);
    }
}
