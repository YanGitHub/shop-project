package com.power.saas.dao;

import com.power.saas.entity.BillMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>点菜信息表 BillMenuDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface BillMenuDao {

    int insert(BillMenu record);

    int updateByPrimaryKey(BillMenu record);

    int updateByPrimaryKeySelective(BillMenu record);

    BillMenu selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(BillMenu record);

    List<BillMenu> queryByList(BillMenu record);

}
