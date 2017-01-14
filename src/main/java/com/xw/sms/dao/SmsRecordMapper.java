package com.xw.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xw.sms.entity.SmsRecordEntity;

/** 
* @Description: 短信记录表操作的dao接口 
* @author hjd
* @date 2017年1月9日 下午2:28:05 
*  
*/
@Mapper
public interface SmsRecordMapper {
	@Insert("insert into sms_record(mobile,sendTime,signName,templateCode,paramString,requestId,statusCode,message) "
			+ "values(#{mobile},#{sendTime},#{signName},#{templateCode},#{paramString},#{requestId},#{statusCode},#{message})")
	int addSms(SmsRecordEntity smsRecord);
	
	@Select("select * from sms_record where mobile = #{mobile}")
	List<SmsRecordEntity> findRecordByMobile(@Param("mobile") String mobile); //根据手机号查询短信发送记录
	
}
