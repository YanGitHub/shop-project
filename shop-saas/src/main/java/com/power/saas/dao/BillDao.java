package com.power.saas.dao;

import com.power.saas.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>开台单信息表 BillDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface BillDao {

    int insert(Bill record);

    int updateByPrimaryKey(Bill record);

    int updateByPrimaryKeySelective(Bill record);

    Bill selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(Bill record);

    List<Bill> queryByList(Bill record);

}
