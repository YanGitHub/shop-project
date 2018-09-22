package com.power.saas.entity;

import com.power.saas.common.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * <br>
 * <b>功能：</b>桌台信息表 DeskInfoEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Alias("DeskInfo")
public class DeskInfo extends BaseEntity{
	//
	private Long id;
	//桌台类型 t_desk_type id
	private Long typeId;
	//状态 t_desk_status id
	private Long statusId;
	//桌台名称
	private String name;
	//桌台编码
	private String code;

	private DeskStatus deskStatus;

	private DeskType deskType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DeskStatus getDeskStatus() {
		return deskStatus;
	}

	public void setDeskStatus(DeskStatus deskStatus) {
		this.deskStatus = deskStatus;
	}

	public DeskType getDeskType() {
		return deskType;
	}

	public void setDeskType(DeskType deskType) {
		this.deskType = deskType;
	}
}

