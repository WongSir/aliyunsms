package com.xw.sms.utils;

/** 
* @Description: ʹ��ö�����Ͷ��巵�ؽ��״̬�� 
* @author hjd
* @date 2017��1��9�� ����7:29:54 
*  
*/
public enum RespCode {
	
	SUCCESS("�ɹ�",0),
	FAIL("ʧ��",1);
	
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
