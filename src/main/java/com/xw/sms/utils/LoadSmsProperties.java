package com.xw.sms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 
* @Description: 短信配置文件读取类 
* @author hjd
* @date 2017年1月9日 上午11:45:41 
*  
*/
public class LoadSmsProperties {
	
	/**
	 * 通过key值获取阿里云短信配置文件中的value值 
	 * @param key 配置文件中的key值
	 * @return
	 */
	public static String readSmsValue(String key){
		String fileName  = "/aliyun_sms.properties";
		Properties pro = new Properties();
		InputStream in = null;
		String value="";
		try {
			in = LoadSmsProperties.class.getResourceAsStream(fileName);
			pro.load(in);
			value= pro.getProperty(key);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
}
