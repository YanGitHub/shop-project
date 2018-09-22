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
 * <b>功能：</b>开台单信息表 BillEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Alias("Bill")
public class Bill extends BaseEntity{
    //
	private Long id;
    //开台单编号
	private String billNo;
    //桌台 id t_desk_id
	private Long deskId;
    //会员编码
	private String vipCode;
    //人数
	private Integer personNum;
    //时间
	private String time;
    //会员
	private String vipName;
    //备注
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

	public Long getDeskId() {
		return this.deskId;
	}

	public void setDeskId(Long deskId) {
		this.deskId = deskId;
	}

	public String getVipCode() {
		return this.vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public Integer getPersonNum() {
		return this.personNum;
	}

	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVipName() {
		return this.vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}

