package com.xw;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/** 
* @Description: TODO 
* @author hjd
* @date 2017��2��10�� ����10:58:12 
*  
*/
public class ServletInitializer extends SpringBootServletInitializer{
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(App.class);  
    }  
}
