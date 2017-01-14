package com.xw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xw.sms.interceptor.IpInterceptor;

/** 
* @Description: Spring Boot������ 
* @author hjd
* @date 2017��1��7�� ����4:48:44 
*  
*/
@SpringBootApplication
public class App extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * ���������֮ǰ�ȼ���ʵ�壬����null�쳣
	 * @return
	 */
	@Bean
    public HandlerInterceptor getIpInterceptor(){
        return new IpInterceptor();
    }
	
	/**
	 * ����������
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getIpInterceptor());
		System.out.println("***����������***");
	}
	
}
