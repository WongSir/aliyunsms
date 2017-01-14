package com.xw.sms.utils;

import static com.xw.sms.utils.RespCode.*;
/** 
* @Description: 结果返回 
* @author hjd
* @date 2017年1月9日 下午7:38:34 
*  
*/
public class ResultData {
	//0:成功  1：失败
	private int code;
	private String message;
	private Object data;
	
	public ResultData(){
		this.code = SUCCESS.getIndex();
		this.message = SUCCESS.getName();
	}
	
	public void setCode(RespCode code) {
		this.code = code.getIndex();
		this.message = code.getName();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
