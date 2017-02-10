package com.xw;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/** 
* @Description: TODO 
* @author hjd
* @date 2017年2月10日 上午10:58:12 
*  
*/
public class ServletInitializer extends SpringBootServletInitializer{
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(App.class);  
    }  
}
