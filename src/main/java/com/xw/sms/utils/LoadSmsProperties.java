package com.xw.sms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 
* @Description: ���������ļ���ȡ�� 
* @author hjd
* @date 2017��1��9�� ����11:45:41 
*  
*/
public class LoadSmsProperties {
	
	/**
	 * ͨ��keyֵ��ȡ�����ƶ��������ļ��е�valueֵ 
	 * @param key �����ļ��е�keyֵ
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
