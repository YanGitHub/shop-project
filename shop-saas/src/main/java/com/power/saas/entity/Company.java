package com.power.saas.entity;

import com.power.saas.common.BaseEntity;
import org.apache.ibatis.type.Alias;

/**
 * 
 * <br>
 * <b>功能：</b>公司信息 CompanyEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-21 <br>
 */
@Alias("Company")
public class Company extends BaseEntity {
    //
	private Long id;
    //公司名称
	private String name;
    //地址
	private String address;
    //电话
	private String mobile;
    //税号
	private String dutyParagraph;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDutyParagraph() {
		return this.dutyParagraph;
	}

	public void setDutyParagraph(String dutyParagraph) {
		this.dutyParagraph = dutyParagraph;
	}
}

