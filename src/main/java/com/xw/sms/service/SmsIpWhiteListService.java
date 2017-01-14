package com.xw.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xw.sms.dao.SmsIpWhiteListMapper;
import com.xw.sms.entity.SmsIpWhiteListEntity;

/** 
* @Description: ip地址白名单业务处理类
* @author hjd
* @date 2017年1月14日 下午3:37:48 
*  
*/
@Service
public class SmsIpWhiteListService {
	@Autowired
	private SmsIpWhiteListMapper smsIpWhiteListMapper;
	
	@Transactional
	public int addIp(SmsIpWhiteListEntity ip){
		int addCount=0;
		try {
			addCount = smsIpWhiteListMapper.addIp(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addCount;
	}
	@Transactional
	public SmsIpWhiteListEntity searchIp(String ip){
		SmsIpWhiteListEntity whitelist =  new SmsIpWhiteListEntity();
		try {
			whitelist = smsIpWhiteListMapper.findByIp(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return whitelist;
		
	}
}
