package com.xw.sms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.xw.sms.view.SmsRecordView;

/** 
* @Description: ���ż�¼ʵ���� 
* @author hjd
* @date 2017��1��9�� ����11:56:25 
*  
*/
public class SmsRecordEntity {
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String mobile;//�ֻ���
	@JsonView(SmsRecordView.SmsByMobile.class)
	private Date sendTime;//��Ϣ����ʱ��
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String signName;//����ǩ��
	private String templateCode;//ģ��code
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String paramString;//����ģ������������ַ������������ݿ�洢
	private ParamJson paramJson;//����ģ�����������ʵ�壬���ڽ��ղ���
	private String requestId;//ϵͳΨһʶ����
	@JsonView(SmsRecordView.SmsByMobile.class)
	private int statusCode;//���ŷ���״̬��Http״̬�룩
	@JsonView(SmsRecordView.SmsByMobile.class)
	private String message;//���ŷ���״̬����
	
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
