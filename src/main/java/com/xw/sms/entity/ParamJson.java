package com.xw.sms.entity;

/** 
* @Description: ��һ��ʵ�������ն��ŵĸ����������� �ٽ���ת��
* @author hjd
* @date 2017��1��10�� ����10:29:48 
*  
*/
public class ParamJson {
	private String name;
	private String addr;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ParamJson [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
}
