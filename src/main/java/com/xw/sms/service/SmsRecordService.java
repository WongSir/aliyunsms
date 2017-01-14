package com.xw.sms.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xw.sms.dao.SmsRecordMapper;
import com.xw.sms.entity.SmsRecordEntity;
import com.xw.sms.utils.GlobalVariable;

/** 
* @Description: ���ż�¼ҵ���߼������� 
* @author hjd
* @date 2017��1��9�� ����2:52:41 
*  
*/
@Service
public class SmsRecordService {
	private final static Logger log = LogManager.getLogger(SmsRecordService.class);
	
	@Autowired
	private SmsRecordMapper smsRecordMapper;
	
	public int addSms(SmsRecordEntity smsRecord){
		//�˴��������ݴ���:���ӵ�ǰʱ�䡢requestId�����ű�������paramString
		smsRecord.setSendTime(GlobalVariable.smsRecord.getSendTime());
		smsRecord.setRequestId(GlobalVariable.smsRecord.getRequestId());
		smsRecord.setParamString(GlobalVariable.smsRecord.getParamString());
		
		int addCount = smsRecordMapper.addSms(smsRecord);
		log.info("Have successfully inserted"+addCount+"SMS record");
		return addCount;
	}
	
	public List<SmsRecordEntity> findRecordByMobile(String mobile){
		List<SmsRecordEntity> smsRecord = smsRecordMapper.findRecordByMobile(mobile);
		return smsRecord;
	}
}
