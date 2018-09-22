package com.power.saas.service;

import com.power.saas.dao.MenuTypeDao;
import com.power.saas.entity.MenuType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>菜单类别表 MenuTypeServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Service
public class MenuTypeService {

    public final static Logger logger = LoggerFactory.getLogger(MenuTypeService.class);

    @Autowired
    private MenuTypeDao dao;

    @Transactional
    public int insert(MenuType record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(MenuType record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(MenuType record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public MenuType selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(MenuType record) {
        return dao.queryByCount(record);
    }

    public List<MenuType> queryByList(MenuType record) {
        return dao.queryByList(record);
    }
}
