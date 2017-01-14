package com.xw.sms.utils;

import com.xw.sms.entity.SmsRecordEntity;

/** 
* @Description: 设置全局变量，用于实体集之间的值传递 
* @author hjd
* @date 2017年1月10日 上午11:48:46 
*  可以在类中定义全局静态变量，也可以定义枚举类型
*/
public class GlobalVariable {
	public static SmsRecordEntity smsRecord = new SmsRecordEntity();
}
