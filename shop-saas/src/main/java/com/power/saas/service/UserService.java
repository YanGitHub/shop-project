package com.power.saas.service;

import com.power.saas.dao.UserDao;
import com.power.saas.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>用户信息表 UserServiceImpl<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-21 <br>
 */
@Service
public class UserService {

    public final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao dao;

    @Transactional
    public int insert(User record) {
        return dao.insert(record);
    }

    @Transactional
    public int updateByPrimaryKey(User record) {
        return dao.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(User record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public User selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Transactional
    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int queryByCount(User record) {
        return dao.queryByCount(record);
    }

    public List<User> queryByList(User record) {
        return dao.queryByList(record);
    }
}
