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
* @Description: ip��ַ������������ 
* @author hjd
* @date 2017��1��14�� ����2:46:46 
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
	 * ǰ�ü��
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SmsIpWhiteListEntity whitelist =  new SmsIpWhiteListEntity();
		String ip;
		if(request.getHeader("x-forwarded-for")==null){
			ip = request.getRemoteAddr();
			System.out.println("ʹ����ipΪ��" + ip);
		}else{
			ip = request.getHeader("x-forwarded-for");
			System.out.println("ʹ����ipΪ��" + ip);
		}
		whitelist = smsIpWhiteListService.searchIp(ip);
		if(whitelist == null){
			System.out.println("������У��ʧ��");
			return false;
		}else{
			if(whitelist.getIp().equals(ip)){
				System.out.println("������У��ɹ�");
				return true;
			}
		}
		System.out.println("������У��ʧ��");
		return false;
//		return smsIpWhiteListService.searchIp(ip).getIp().equals(ip);
	}

}
