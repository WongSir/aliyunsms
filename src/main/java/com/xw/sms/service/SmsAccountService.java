package com.xw.sms.service;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xw.sms.dao.SmsAccountMapper;
import com.xw.sms.entity.SmsAccountEntity;

/**
 * @Description: 短信账户业务处理类
 * @author hjd
 * @date 2017年1月12日 下午8:01:43
 * 
 */
@Service
public class SmsAccountService {
	private final static Logger log = LogManager.getLogger(SmsAccountService.class);

	@Autowired
	private SmsAccountMapper smsAccountMapper;

	@Transactional
	@SuppressWarnings("finally")
	public int setAccount(SmsAccountEntity smsAccount) {
		int id = 0;
		try {
			smsAccountMapper.setSmsAccount(smsAccount);
			id = smsAccount.getId();
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("插入数据并获取自增id,开始");
			log.error(e.getMessage());
			log.error("失败，事务回滚，结束。");
		} finally {
			if (id <= 0) {
				log.error("获取自增id失败");
			}
			return id;
		}

	}

	/**
	 * 此处的更新策略为：每调用接口一次，则默认发送了一条短信，从而短信剩余数自动减1
	 * @param smsAccount
	 * @param id
	 * @return
	 */
	@Transactional
	public int updateAccountById(int id) {
		SmsAccountEntity smsAccount = new SmsAccountEntity();
		smsAccount = smsAccountMapper.findById(id);
		int updateCount = 0;
		//获取当前时间
		smsAccount.setUpdateTime(new Date());
		//更新剩余条数和已发送条数
		if(smsAccount.getRemain()<=0 || smsAccount.getSend()>=smsAccount.getAmount()){
			return updateCount;
		}else{
			smsAccount.setRemain(smsAccount.getRemain()-1);
			smsAccount.setSend(smsAccount.getSend()+1);
		}
		try {
			updateCount = smsAccountMapper.updateSmsAccountById(smsAccount, id);
			log.info("已成功更新" + updateCount + "条记录");
		} catch (Exception e) {
			log.error("数据更新失败！");
		}
		return updateCount;
	}

	public SmsAccountEntity findById(int id) {
		SmsAccountEntity smsAccount = smsAccountMapper.findById(id);
		return smsAccount;
	}
	
	@Transactional
	public int closeSmsAccountById(SmsAccountEntity smsAccount,int id){
		int count =0;
		try{
			count = smsAccountMapper.closeSmsAccountById(smsAccount, id);
		}catch (Exception e) {
			log.error("关闭账户失败！");
		}
		return count;
		
	}
}
