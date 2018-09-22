package com.power.saas.service;

import com.power.saas.dao.MenuInfoDao;
import com.power.saas.entity.MenuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>菜单信息表 MenuInfoServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class MenuInfoService {

    public final static Logger logger = LoggerFactory.getLogger(MenuInfoService.class);

    @Autowired
    private MenuInfoDao dao;

    @Transactional
    public int insert(MenuInfo record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(MenuInfo record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(MenuInfo record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public MenuInfo selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(MenuInfo record) {
        return dao.queryByCount(record);
    }

    public List<MenuInfo> queryByList(MenuInfo record) {
        return dao.queryByList(record);
    }
}
