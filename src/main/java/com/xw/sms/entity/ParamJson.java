package com.xw.sms.entity;

/** 
* @Description: 用一个实体来接收短信的各个变量参数 再进行转换
* @author hjd
* @date 2017年1月10日 上午10:29:48 
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
