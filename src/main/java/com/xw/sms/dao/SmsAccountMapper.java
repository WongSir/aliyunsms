package com.xw.sms.dao;

import java.sql.ResultSet;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.xw.sms.entity.SmsAccountEntity;

/** 
* @Description: 短信账户配置的dao接口 
* @author hjd
* @date 2017年1月12日 下午7:44:12 
*  
*/
@Mapper
public interface SmsAccountMapper {
	//插入时即取得该条记录的自增id，，插入另一个表中用以关联
	@Insert("insert into sms_account(isOpen,amount,remain,send,createTime,updateTime) values(#{Account.isOpen},#{Account.amount},#{Account.remain},#{Account.send},#{Account.createTime},#{Account.updateTime})")
	@SelectKey(before=false,keyProperty="Account.id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT @@identity AS id")  
//	@Select("SELECT LAST_INSERT_ID() AS id")
	int setSmsAccount(@Param("Account") SmsAccountEntity account);
	
	//根据id更新短信账户表
	@Update("update sms_account set isOpen=#{Account.isOpen},amount=#{Account.amount},remain=#{Account.remain},send=#{Account.send},updateTime=#{Account.updateTime} where id=#{id}")
	int updateSmsAccountById(@Param("Account") SmsAccountEntity account,@Param("id") int id);
	
	@Select("select * from sms_account where id = #{id}")
	SmsAccountEntity findById(@Param("id") int id);
	
	//根据关闭短信账户表
	@Update("update sms_account set isOpen=#{Account.isOpen} where id=#{id}")
	int closeSmsAccountById(@Param("Account") SmsAccountEntity account,@Param("id") int id);
}
