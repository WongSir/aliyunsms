package com.xw.sms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xw.sms.entity.SmsIpWhiteListEntity;

/** 
* @Description: ip地址白名单dao接口 
* @author hjd
* @date 2017年1月14日 下午3:24:14 
*  
*/
@Mapper
public interface SmsIpWhiteListMapper {

	@Insert("insert into sms_ip_whitelist(ip) value(#{ip})")
	int addIp(SmsIpWhiteListEntity ip);
	
	//根据获取的调用sms接口的ip从数据库中查询，如果可以查到数据，说明该ip存在于白名单中
	@Select("select * from sms_ip_whitelist where ip = #{ip}")
	SmsIpWhiteListEntity findByIp(@Param("ip") String ip);

	/**
	 * @return
	 */
	List<SmsIpWhiteListEntity> findAll();
}
