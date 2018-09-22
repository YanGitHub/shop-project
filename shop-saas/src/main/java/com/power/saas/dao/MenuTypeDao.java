package com.power.saas.dao;

import com.power.saas.entity.MenuType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>菜单类别表 MenuTypeDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface MenuTypeDao {

    int insert(MenuType record);

    int updateByPrimaryKey(MenuType record);

    int updateByPrimaryKeySelective(MenuType record);

    MenuType selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(MenuType record);

    List<MenuType> queryByList(MenuType record);

}
