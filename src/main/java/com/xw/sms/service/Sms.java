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
* @Description: �����ࣺ���ŷ����� 
* @author hjd
* @date 2017��1��9�� ����2:51:13 
*  
*/
@Service
public class Sms {
	
	private final static Logger log = LogManager.getLogger(Sms.class);
//	SmsRecordEntity smsRecord = new SmsRecordEntity();
	SingleSendSmsResponse httpResponse = new SingleSendSmsResponse();
	
	private static String region_id = "";//������regionId
	private static String access_key_id = "";    //������ accessKeyId
    private static String access_key_secret = "";    //������ accessKeySecret
    private static String end_point_name = "";   //������end_point_name
    private static String product = "";  //�����Ʋ�Ʒ
    private static String domain = "";   //�����Ƶ��ö��ŷ���ƽ̨�ӿ�����
	
    static{
    	region_id = LoadSmsProperties.readSmsValue("region_id");
        access_key_id = LoadSmsProperties.readSmsValue("access_key_id");
        access_key_secret = LoadSmsProperties.readSmsValue("access_key_secret");
        end_point_name = LoadSmsProperties.readSmsValue("end_point_name");
        product = LoadSmsProperties.readSmsValue("product");
        domain = LoadSmsProperties.readSmsValue("domain");
   }
    /**
     * ���ķ������������ŷ��ͷ���
     * @param mobile �ֻ���
     * @param signName ����ǩ��
     * @param templateCode ����ģ��code
     * @param paramJson ����ģ���������
     * @return ���ŷ��ͳɹ�����true������ʧ�ܷ���false��
     */
    @SuppressWarnings("finally")
	public boolean singleSendSms(String mobile,String signName,String templateCode,ParamJson paramJson){
		boolean isSendSuccess = false;
		//������תΪ�ַ���
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
			//��ȡ��ǰʱ���Ψһʶ����requestId
			Date date = new Date();
			GlobalVariable.smsRecord.setSendTime(date);
			
			GlobalVariable.smsRecord.setRequestId(httpResponse.getRequestId());
			
			return isSendSuccess;
		}
    	
    }
}
