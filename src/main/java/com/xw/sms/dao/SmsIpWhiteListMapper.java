package com.xw.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xw.sms.entity.SmsIpWhiteListEntity;

/** 
* @Description: ip��ַ������dao�ӿ� 
* @author hjd
* @date 2017��1��14�� ����3:24:14 
*  
*/
@Mapper
public interface SmsIpWhiteListMapper {

	@Insert("insert into sms_ip_whitelist(ip) value(#{ip})")
	int addIp(SmsIpWhiteListEntity ip);
	
	//���ݻ�ȡ�ĵ���sms�ӿڵ�ip�����ݿ��в�ѯ��������Բ鵽���ݣ�˵����ip�����ڰ�������
	@Select("select * from sms_ip_whitelist where ip = #{ip}")
	SmsIpWhiteListEntity findByIp(@Param("ip") String ip);

	/**
	 * @return
	 */
	List<SmsIpWhiteListEntity> findAll();
}
