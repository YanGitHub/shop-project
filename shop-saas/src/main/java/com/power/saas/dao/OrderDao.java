package com.power.saas.dao;

import com.power.saas.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>销售统计表 OrderDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface OrderDao {

    int insert(Order record);

    int updateByPrimaryKey(Order record);

    int updateByPrimaryKeySelective(Order record);

    Order selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(Order record);

    List<Order> queryByList(Order record);

}
