package com.xw.sms.controller;

import static com.xw.sms.utils.RespCode.FAIL;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xw.sms.entity.SmsAccountEntity;
import com.xw.sms.service.SmsAccountService;
import com.xw.sms.utils.ResultData;

/** 
* @Description: TODO 
* @author hjd
* @date 2017��1��13�� ����9:25:09 
*  
*/
@RestController
@RequestMapping(value="/sms")
public class SmsAccountController {
	private final static Logger log = LogManager.getLogger(SmsAccountController.class);
	@Autowired
	private SmsAccountService smsAccountService;	
	
	@RequestMapping(value="/account/setaccount")
	public ResultData setSmsAccount(@RequestBody SmsAccountEntity smsAccount){
		ResultData rd = new ResultData();
		//��ȡ��ǰʱ��
		smsAccount.setCreateTime(new Date());
		smsAccount.setUpdateTime(new Date());
		smsAccount.setRemain(smsAccount.getAmount());
		try{
			int id = smsAccountService.setAccount(smsAccount);
			log.info("��ǰ��¼������idΪ ��"+ id);
			rd.setData("�����˻����óɹ�");
		}catch (Exception e) {
			rd.setCode(FAIL);
			rd.setData("�����˻�����ʧ��");
		}
		
		return rd;
	}
	
	@RequestMapping(value="/account/updateaccount/{id}")
	public ResultData updateSmsAccoutById(@PathVariable int id){
		ResultData rd = new ResultData();
		int updateCount=0;
		try{
			updateCount = smsAccountService.updateAccountById(id);
			rd.setData("�����˻����³ɹ�");
		}catch (Exception e) {
			rd.setCode(FAIL);
			rd.setData("�����˻�����ʧ��");
		}
		if(updateCount<=0){
			rd.setCode(FAIL);
			rd.setData("�����˻�����ʧ��");
		}
		return rd;
	}
	
	
	@RequestMapping(value="/account/search/{id}")
	public SmsAccountEntity searchById(@PathVariable int id){
		SmsAccountEntity smsAccount = smsAccountService.findById(id);
		if(smsAccount ==null){
			log.info("��id�µļ�¼Ϊ�գ�");
		}
		return smsAccount;
	}
	
	@RequestMapping(value="/account/close/{id}")
	public ResultData closeAccountById(@RequestBody SmsAccountEntity smsAccount,@PathVariable int id){
		ResultData rd = new ResultData();
		int count =0;
		try{
			count = smsAccountService.closeSmsAccountById(smsAccount, id);
			rd.setData("�����˻��ѹر�");
		}catch (Exception e) {
			rd.setCode(FAIL);
			rd.setData("�����˻��ر�ʧ��");
		}
		if(count<=0){
			rd.setCode(FAIL);
			rd.setData("�����˻��ر�ʧ��");
		}
		return rd;
	}
}
