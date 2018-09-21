package com.power.saas.entity;

import com.power.saas.common.BaseEntity;
import org.apache.ibatis.type.Alias;

/**
 * 
 * <br>
 * <b>功能：</b>用户信息表 UserEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-21 <br>
 */
@Alias("User")
public class User extends BaseEntity{
    //
	private Long id;
    //用户名
	private String userName;
    //密码
	private String password;
    //1管理员 2操作员
	private Integer type;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}

