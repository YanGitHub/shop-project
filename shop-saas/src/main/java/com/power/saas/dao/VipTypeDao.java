package com.power.saas.dao;

import com.power.saas.entity.VipType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>会员类型表 VipTypeDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface VipTypeDao {

    int insert(VipType record);

    int updateByPrimaryKey(VipType record);

    int updateByPrimaryKeySelective(VipType record);

    VipType selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(VipType record);

    List<VipType> queryByList(VipType record);

}
