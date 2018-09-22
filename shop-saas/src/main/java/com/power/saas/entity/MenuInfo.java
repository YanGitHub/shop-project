package com.power.saas.entity;

import com.power.saas.common.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * <br>
 * <b>功能：</b>菜单信息表 MenuInfoEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Alias("MenuInfo")
public class MenuInfo extends BaseEntity{
    //
	private Long id;
    //编号
	private String code;
    //名称
	private String name;
    //价格
	private BigDecimal realPrice;
    //单位
	private String unit;
    //原价
	private BigDecimal untPrice;
    //积分基数
	private BigDecimal pointBase;
    //菜单类别编号 t_menu_type id
	private Long typeId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRealPrice() {
		return this.realPrice;
	}

	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getUntPrice() {
		return this.untPrice;
	}

	public void setUntPrice(BigDecimal untPrice) {
		this.untPrice = untPrice;
	}

	public BigDecimal getPointBase() {
		return this.pointBase;
	}

	public void setPointBase(BigDecimal pointBase) {
		this.pointBase = pointBase;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
}

