package com.ssafy.webex.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	@Before(value="execution(* com.ssafy.webex..*.*(..))")
	public void logging(JoinPoint jp) {
		
		logger.debug("메소드 선언부 : {}, 전달 파라미터 : {}", 
				jp.getSignature(),
				Arrays.toString(jp.getArgs()));
	}
	
}
