package com.power.saas.dao;

import com.power.saas.entity.DeskStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>桌台状态表 DeskStatusDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface DeskStatusDao {

    int insert(DeskStatus record);

    int updateByPrimaryKey(DeskStatus record);

    int updateByPrimaryKeySelective(DeskStatus record);

    DeskStatus selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(DeskStatus record);

    List<DeskStatus> queryByList(DeskStatus record);

}
