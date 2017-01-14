package com.xw.sms.entity;

import java.util.Date;

/** 
* @Description: 短信账户实体类 
* @author hjd
* @date 2017年1月12日 下午7:09:38 
*  
*/
public class SmsAccountEntity {
	private int id; //短信账户id
	private int isOpen;//是否开通短信通知服务 0:开通 1：未开通  默认为1
	private int amount;//短信总条数
	private int remain;//剩余条数
	private int send;//已发送条数
	private Date createTime;//创建时间
	private Date updateTime;//最后更新时间
	
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountEntity [isOpen=" + isOpen + ", amount=" + amount + ", remain=" + remain + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSend() {
		return send;
	}
	public void setSend(int send) {
		this.send = send;
	}
	
}
