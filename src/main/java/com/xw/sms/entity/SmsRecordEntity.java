package com.xw.sms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.xw.sms.view.SmsRecordView;

/** 
* @Description: 短信记录实体类 
* @author hjd
* @date 2017年1月9日 上午11:56:25 
*  
*/
public class SmsRecordEntity {
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String mobile;//手机号
	@JsonView(SmsRecordView.SmsByMobile.class)
	private Date sendTime;//信息发送时间
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String signName;//短信签名
	private String templateCode;//模板code
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String paramString;//短信模板变量参数的字符串，用于数据库存储
	private ParamJson paramJson;//短信模板变量参数的实体，用于接收参数
	private String requestId;//系统唯一识别码
	@JsonView(SmsRecordView.SmsByMobile.class)
	private int statusCode;//短信发送状态（Http状态码）
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String message;//短信发送状态描述
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public ParamJson getParamJson() {
		return paramJson;
	}
	public void setParamJson(ParamJson paramJson) {
		this.paramJson = paramJson;
	}
		public String getParamString() {
		return paramString;
	}
	public void setParamString(String paramString) {
		this.paramString = paramString;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
