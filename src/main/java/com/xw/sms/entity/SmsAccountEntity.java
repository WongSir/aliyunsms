package com.xw.sms.entity;

import java.util.Date;

/** 
* @Description: �����˻�ʵ���� 
* @author hjd
* @date 2017��1��12�� ����7:09:38 
*  
*/
public class SmsAccountEntity {
	private int id; //�����˻�id
	private int isOpen;//�Ƿ�ͨ����֪ͨ���� 0:��ͨ 1��δ��ͨ  Ĭ��Ϊ1
	private int amount;//����������
	private int remain;//ʣ������
	private int send;//�ѷ�������
	private Date createTime;//����ʱ��
	private Date updateTime;//������ʱ��
	
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
