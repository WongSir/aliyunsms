package com.xw.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xw.sms.entity.SmsRecordEntity;

/** 
* @Description: ���ż�¼�������dao�ӿ� 
* @author hjd
* @date 2017��1��9�� ����2:28:05 
*  
*/
@Mapper
public interface SmsRecordMapper {
	@Insert("insert into sms_record(mobile,sendTime,signName,templateCode,paramString,requestId,statusCode,message) "
			+ "values(#{mobile},#{sendTime},#{signName},#{templateCode},#{paramString},#{requestId},#{statusCode},#{message})")
	int addSms(SmsRecordEntity smsRecord);
	
	@Select("select * from sms_record where mobile = #{mobile}")
	List<SmsRecordEntity> findRecordByMobile(@Param("mobile") String mobile); //�����ֻ��Ų�ѯ���ŷ��ͼ�¼
	
}
