package com.power.saas.dao;

import com.power.saas.entity.DeskInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>桌台信息表 DeskInfoDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface DeskInfoDao {

    int insert(DeskInfo record);

    int updateByPrimaryKey(DeskInfo record);

    int updateByPrimaryKeySelective(DeskInfo record);

    DeskInfo selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(DeskInfo record);

    List<DeskInfo> queryByList(DeskInfo record);

}
