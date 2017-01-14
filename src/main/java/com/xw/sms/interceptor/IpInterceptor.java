package com.xw.sms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xw.sms.entity.SmsIpWhiteListEntity;
import com.xw.sms.service.SmsIpWhiteListService;

/** 
* @Description: ip地址白名单拦截器 
* @author hjd
* @date 2017年1月14日 下午2:46:46 
*  
*/
@Component
public class IpInterceptor implements HandlerInterceptor{

	@Autowired
	private SmsIpWhiteListService smsIpWhiteListService;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 前置检查
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SmsIpWhiteListEntity whitelist =  new SmsIpWhiteListEntity();
		String ip;
		if(request.getHeader("x-forwarded-for")==null){
			ip = request.getRemoteAddr();
			System.out.println("使用者ip为：" + ip);
		}else{
			ip = request.getHeader("x-forwarded-for");
			System.out.println("使用者ip为：" + ip);
		}
		whitelist = smsIpWhiteListService.searchIp(ip);
		if(whitelist == null){
			System.out.println("白名单校验失败");
			return false;
		}else{
			if(whitelist.getIp().equals(ip)){
				System.out.println("白名单校验成功");
				return true;
			}
		}
		System.out.println("白名单校验失败");
		return false;
//		return smsIpWhiteListService.searchIp(ip).getIp().equals(ip);
	}

}
