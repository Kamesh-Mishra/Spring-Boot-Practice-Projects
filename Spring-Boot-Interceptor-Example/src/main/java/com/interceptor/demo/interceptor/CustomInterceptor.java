package com.interceptor.demo.interceptor;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomInterceptor implements HandlerInterceptor {

	private static final Logger logger =  Logger.getLogger(CustomInterceptor.class.getName());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("Pre Handle method is Calling");
        logger.info("Request URL: " + request.getRequestURL());
        logger.info("Request Method: " + request.getMethod());
        return true; // Continue with the request
	}
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Post Handle method is Calling");
        logger.info("Response Status: " + response.getStatus());
    }
	
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("After Completion method is Calling");
        if (ex != null) {
            logger.severe("Exception: " + ex.getMessage());
        }
    }
	
}
