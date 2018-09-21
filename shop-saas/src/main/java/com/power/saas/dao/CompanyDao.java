package com.power.saas.dao;

import com.power.saas.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>公司信息 CompanyDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-21 <br>
 */
public interface CompanyDao {

    int insert(Company record);

    int updateByPrimaryKey(Company record);

    int updateByPrimaryKeySelective(Company record);

    Company selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(Company record);

    List<Company> queryByList(Company record);

}
