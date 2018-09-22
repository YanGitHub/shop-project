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
 * <b>功能：</b>销售统计表 OrderEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-22 <br>
 */
@Alias("Order")
public class Order extends BaseEntity{
    //
	private Long id;
    //时间
	private Date time;
    //应收
	private BigDecimal receivable;
    //实收
	private BigDecimal actualReceipt;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public BigDecimal getReceivable() {
		return this.receivable;
	}

	public void setReceivable(BigDecimal receivable) {
		this.receivable = receivable;
	}

	public BigDecimal getActualReceipt() {
		return this.actualReceipt;
	}

	public void setActualReceipt(BigDecimal actualReceipt) {
		this.actualReceipt = actualReceipt;
	}
}

