package com.xw.sms.controller;

import static com.xw.sms.utils.RespCode.FAIL;
import static com.xw.sms.utils.RespCode.SUCCESS;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.xw.sms.entity.SmsRecordEntity;
import com.xw.sms.service.Sms;
import com.xw.sms.service.SmsRecordService;
import com.xw.sms.utils.ResultData;
import com.xw.sms.view.SmsRecordView;

/** 
* @Description: TODO 
* @author hjd
* @date 2017��1��9�� ����6:57:13 
*  
*/
@RestController
@RequestMapping("/sms")
public class SmsController {
	private final static Logger log = LogManager.getLogger(SmsController.class);
	@Autowired
	private SmsRecordService smsRecordService;
	@Autowired
	private Sms sms;
	
	/**
	 * ���Ͷ��Ų������ż�¼�洢�����ݿ���
	 * @param smsRecord ���ż�¼ʵ��
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/send",method = RequestMethod.POST)
	public ResultData singleSendSms(@RequestBody SmsRecordEntity smsRecord){
		ResultData rd = new ResultData();
		boolean isSendSuccess = sms.singleSendSms(smsRecord.getMobile(), smsRecord.getSignName(), smsRecord.getTemplateCode(), smsRecord.getParamJson());
//		if(false == isSendSuccess){//isSendSuccessΪfalse�������ŷ���ʧ��
//			rd.setCode(FAIL);
//			return rd;
//		}
		if(isSendSuccess){
			smsRecord.setStatusCode(SUCCESS.getIndex()); //0
			smsRecord.setMessage(SUCCESS.getName()); //�ɹ�
			log.info("send message successed");
		}else{
			smsRecord.setStatusCode(FAIL.getIndex()); //1
			smsRecord.setMessage(FAIL.getName()); //ʧ��
			log.info("send message failed");
		}
		
		try {
			int addCount = smsRecordService.addSms(smsRecord);
			if(addCount<=0){
				log.error("message record insert failed");
			}
			rd.setData("���ŷ��ͳɹ������ݿ�洢�ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			if(false == isSendSuccess){//isSendSuccessΪfalse�������ŷ���ʧ��
				rd.setCode(FAIL);
				rd.setData("���ŷ���ʧ�ܣ����ݿ�洢ʧ�ܣ�");
			}else{
				rd.setData("���ŷ��ͳɹ������ݿ�洢ʧ�ܣ�");
			}
			log.error("*SQL start!*");
			log.error(e.getMessage());
			log.error("*SQL end!*");
		}
		return rd;
	}
	
	@RequestMapping(value="search/{mobile}")
	@JsonView(SmsRecordView.SmsByMobile.class)
	public List<SmsRecordEntity> findRecordByMobile(@PathVariable String mobile){
		List<SmsRecordEntity> list = smsRecordService.findRecordByMobile(mobile);
		if(list==null){
			log.info("no message about this number!");
		}
		return list;
	}
	
}
