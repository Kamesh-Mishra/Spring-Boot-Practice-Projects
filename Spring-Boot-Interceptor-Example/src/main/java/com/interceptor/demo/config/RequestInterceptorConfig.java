package com.interceptor.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.interceptor.demo.interceptor.CustomInterceptor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class RequestInterceptorConfig implements WebMvcConfigurer {

	private CustomInterceptor customInterceptor;
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(customInterceptor);
	    }
	 
	 
}
