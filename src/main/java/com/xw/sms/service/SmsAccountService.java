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
 * @Description: �����˻�ҵ������
 * @author hjd
 * @date 2017��1��12�� ����8:01:43
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
			log.error("�������ݲ���ȡ����id,��ʼ");
			log.error(e.getMessage());
			log.error("ʧ�ܣ�����ع���������");
		} finally {
			if (id <= 0) {
				log.error("��ȡ����idʧ��");
			}
			return id;
		}

	}

	/**
	 * �˴��ĸ��²���Ϊ��ÿ���ýӿ�һ�Σ���Ĭ�Ϸ�����һ�����ţ��Ӷ�����ʣ�����Զ���1
	 * @param smsAccount
	 * @param id
	 * @return
	 */
	@Transactional
	public int updateAccountById(int id) {
		SmsAccountEntity smsAccount = new SmsAccountEntity();
		smsAccount = smsAccountMapper.findById(id);
		int updateCount = 0;
		//��ȡ��ǰʱ��
		smsAccount.setUpdateTime(new Date());
		//����ʣ���������ѷ�������
		if(smsAccount.getRemain()<=0 || smsAccount.getSend()>=smsAccount.getAmount()){
			return updateCount;
		}else{
			smsAccount.setRemain(smsAccount.getRemain()-1);
			smsAccount.setSend(smsAccount.getSend()+1);
		}
		try {
			updateCount = smsAccountMapper.updateSmsAccountById(smsAccount, id);
			log.info("�ѳɹ�����" + updateCount + "����¼");
		} catch (Exception e) {
			log.error("���ݸ���ʧ�ܣ�");
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
			log.error("�ر��˻�ʧ�ܣ�");
		}
		return count;
		
	}
}
