package com.power.saas.dao;

import com.power.saas.entity.VipInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>会员信息表 VipInfoDao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
public interface VipInfoDao {

    int insert(VipInfo record);

    int updateByPrimaryKey(VipInfo record);

    int updateByPrimaryKeySelective(VipInfo record);

    VipInfo selectByPrimaryKey(@Param(value = "id") Long id);

    int deleteByPrimaryKey(@Param(value = "id") Long id);

    int queryByCount(VipInfo record);

    List<VipInfo> queryByList(VipInfo record);

}
