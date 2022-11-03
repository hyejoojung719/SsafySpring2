package com.ssafy.webex.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//aop 설정
@EnableAspectJAutoProxy
//mapper 인터페이스 빈 등록
@MapperScan(basePackages = "com.ssafy.webex.model.mapper")
public class WebMvcConfig {

}
