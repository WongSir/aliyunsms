package com.xw.sms.service;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.xw.sms.entity.ParamJson;
import com.xw.sms.utils.GlobalVariable;
import com.xw.sms.utils.LoadSmsProperties;


/** 
* @Description: 核心类：短信发送类 
* @author hjd
* @date 2017年1月9日 下午2:51:13 
*  
*/
@Service
public class Sms {
	
	private final static Logger log = LogManager.getLogger(Sms.class);
//	SmsRecordEntity smsRecord = new SmsRecordEntity();
	SingleSendSmsResponse httpResponse = new SingleSendSmsResponse();
	
	private static String region_id = "";//阿里云regionId
	private static String access_key_id = "";    //阿里云 accessKeyId
    private static String access_key_secret = "";    //阿里云 accessKeySecret
    private static String end_point_name = "";   //阿里云end_point_name
    private static String product = "";  //阿里云产品
    private static String domain = "";   //阿里云调用短信服务平台接口域名
	
    static{
    	region_id = LoadSmsProperties.readSmsValue("region_id");
        access_key_id = LoadSmsProperties.readSmsValue("access_key_id");
        access_key_secret = LoadSmsProperties.readSmsValue("access_key_secret");
        end_point_name = LoadSmsProperties.readSmsValue("end_point_name");
        product = LoadSmsProperties.readSmsValue("product");
        domain = LoadSmsProperties.readSmsValue("domain");
   }
    /**
     * 核心方法：单条短信发送服务
     * @param mobile 手机号
     * @param signName 短信签名
     * @param templateCode 短信模板code
     * @param paramJson 短信模板变量参数
     * @return 短信发送成功返回true，发送失败返回false。
     */
    @SuppressWarnings("finally")
	public boolean singleSendSms(String mobile,String signName,String templateCode,ParamJson paramJson){
		boolean isSendSuccess = false;
		//将对象转为字符串
		String paramString = JSON.toJSONString(paramJson);
		paramJson.setAddr("("+paramJson.getAddr()+")");
		String paramStringTmp = JSON.toJSONString(paramJson);
		
		try {
			IClientProfile profile = DefaultProfile.getProfile(region_id, access_key_id, access_key_secret);
			DefaultProfile.addEndpoint(end_point_name, region_id, product, domain);
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			
			request.setSignName(signName);
			request.setTemplateCode(templateCode);
			request.setParamString(paramStringTmp);
			request.setRecNum(mobile);
			
			 httpResponse = client.getAcsResponse(request);
			
			isSendSuccess=true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("*aliyun_sms_begin*");
			log.error(e.getMessage());
			log.error("*aliyun_sms_end*");
		}finally{
			GlobalVariable.smsRecord.setParamString(paramString);
			//获取当前时间和唯一识别码requestId
			Date date = new Date();
			GlobalVariable.smsRecord.setSendTime(date);
			
			GlobalVariable.smsRecord.setRequestId(httpResponse.getRequestId());
			
			return isSendSuccess;
		}
    	
    }
}
