package com.ssafy.webex.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.webex.interceptor.LoginInterceptor;

@Configuration
@EnableAspectJAutoProxy	//aop autoproxy 설정
@MapperScan(basePackages = {"com.ssafy.webex.model.mapper"})	//매퍼 인터페이스 스캔
public class WebMvcConfig implements WebMvcConfigurer{

	//인터셉터 등록
	@Autowired
	LoginInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//해당 요청 인터셉트
		registry.addInterceptor(interceptor).addPathPatterns("/books/**");
		//해당 요청을 제외한 나머지 요청들 인터셉트
//		registry.addInterceptor(interceptor).excludePathPatterns("/user/**");
	}
	
}
