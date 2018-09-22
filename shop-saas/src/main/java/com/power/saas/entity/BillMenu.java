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
 * <b>功能：</b>点菜信息表 BillMenuEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Alias("BillMenu")
public class BillMenu extends BaseEntity{
    //
	private Long id;
    //t_bill bill_no
	private String billNo;
    //菜单编号
	private String menuCode;
    //类别
	private String menuTypeCode;
    //时间
	private String time;
    //数量
	private Integer num;
    //是否结账 1已结 0 未结
	private Integer isSettled;
    //
	private String note;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuTypeCode() {
		return this.menuTypeCode;
	}

	public void setMenuTypeCode(String menuTypeCode) {
		this.menuTypeCode = menuTypeCode;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getIsSettled() {
		return this.isSettled;
	}

	public void setIsSettled(Integer isSettled) {
		this.isSettled = isSettled;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}

