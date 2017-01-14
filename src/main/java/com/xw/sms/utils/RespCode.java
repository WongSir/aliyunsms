package com.xw.sms.utils;

/** 
* @Description: 使用枚举类型定义返回结果状态码 
* @author hjd
* @date 2017年1月9日 下午7:29:54 
*  
*/
public enum RespCode {
	
	SUCCESS("成功",0),
	FAIL("失败",1);
	
	private String name;
	private int index;
	
	private RespCode(String name,int index){
		this.name= name;
		this.index= index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
