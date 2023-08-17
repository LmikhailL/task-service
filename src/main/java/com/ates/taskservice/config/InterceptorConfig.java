package com.ates.taskservice.config;

import com.ates.taskservice.interceptor.RoleInterceptor;
import com.ates.taskservice.interceptor.UserUuidInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	UserUuidInterceptor userUuidInterceptor;
	@Autowired
	RoleInterceptor roleInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userUuidInterceptor);
		registry.addInterceptor(roleInterceptor);
	}
}