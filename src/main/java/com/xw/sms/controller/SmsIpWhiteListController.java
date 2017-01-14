package com.xw.sms.controller;

import static com.xw.sms.utils.RespCode.FAIL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xw.sms.entity.SmsIpWhiteListEntity;
import com.xw.sms.service.SmsIpWhiteListService;
import com.xw.sms.utils.ResultData;

/** 
* @Description: ip��ַ������Controller 
* @author hjd
* @date 2017��1��14�� ����3:52:34 
*  
*/
@RestController
@RequestMapping(value="/sms")
public class SmsIpWhiteListController {

	@Autowired
	private SmsIpWhiteListService smsIpWhiteListService;
	
	@RequestMapping(value="/ip/add",method = RequestMethod.POST)
	public ResultData addIp(@RequestBody SmsIpWhiteListEntity ip){
		ResultData rd = new ResultData();
		int count =0;
		try {
			count = smsIpWhiteListService.addIp(ip);
			
		} catch (Exception e) {
			e.printStackTrace();
			rd.setCode(FAIL);
			rd.setData("ip��ַ���������ʧ��");
		}
		if(count>0){
			rd.setData("ip��ַ��������ӳɹ�");
		}
		return rd;
	}
	//
//	@RequestMapping(value="/ip/search/",method = RequestMethod.POST)
//	public List<SmsIpWhiteListEntity> searchByIp(){
//		List<SmsIpWhiteListEntity> whitelist = new ArrayList<SmsIpWhiteListEntity>();
//		whitelist = smsIpWhiteListService.search();
//		return whitelist;
//	}
}
