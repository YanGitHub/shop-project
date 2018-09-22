package com.power.saas.entity;

import com.power.saas.common.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.lang.Integer;
import java.lang.String;
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
	private Double realPrice;
    //单位
	private String unit;
    //原价
	private Double untPrice;
    //积分基数
	private Double pointBase;
    //菜单类别编号 t_menu_type id
	private Long typeId;
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

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

	public Double getRealPrice() {
		return this.realPrice;
	}

	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getUntPrice() {
		return this.untPrice;
	}

	public void setUntPrice(Double untPrice) {
		this.untPrice = untPrice;
	}

	public Double getPointBase() {
		return this.pointBase;
	}

	public void setPointBase(Double pointBase) {
		this.pointBase = pointBase;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
}

