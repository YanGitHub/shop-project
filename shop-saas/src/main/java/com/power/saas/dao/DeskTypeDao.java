package com.power.saas.dao;

import com.power.saas.entity.DeskType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>桌台类型表 DeskTypeDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface DeskTypeDao {

    int insert(DeskType record);

    int updateByPrimaryKey(DeskType record);

    int updateByPrimaryKeySelective(DeskType record);

    DeskType selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(DeskType record);

    List<DeskType> queryByList(DeskType record);

}
