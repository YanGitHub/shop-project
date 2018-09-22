package com.power.saas.dao;

import com.power.saas.entity.MenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>菜单信息表 MenuInfoDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface MenuInfoDao {

    int insert(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);

    int updateByPrimaryKeySelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(MenuInfo record);

    List<MenuInfo> queryByList(MenuInfo record);

}
