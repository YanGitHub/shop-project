package com.power.saas.service;

import com.power.saas.dao.CompanyDao;
import com.power.saas.entity.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>公司信息 CompanyServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-21 <br>
 */
@Service
public class CompanyService {

    public final static Logger logger = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    private CompanyDao dao;

    @Transactional
    public int insert(Company record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(Company record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(Company record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public Company selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(Company record) {
        return dao.queryByCount(record);
    }

    public List<Company> queryByList(Company record) {
        return dao.queryByList(record);
    }
}
