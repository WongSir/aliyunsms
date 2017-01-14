package com.xw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xw.sms.interceptor.IpInterceptor;

/** 
* @Description: Spring Boot启动类 
* @author hjd
* @date 2017年1月7日 下午4:48:44 
*  
*/
@SpringBootApplication
public class App extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * 添加拦截器之前先加载实体，避免null异常
	 * @return
	 */
	@Bean
    public HandlerInterceptor getIpInterceptor(){
        return new IpInterceptor();
    }
	
	/**
	 * 增加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getIpInterceptor());
		System.out.println("***启动拦截器***");
	}
	
}
