package com.power.saas.dao;

import com.power.saas.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>用户信息表 UserDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-21 <br>
 */
public interface UserDao {

    int insert(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    User selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(User record);

    List<User> queryByList(User record);

}
