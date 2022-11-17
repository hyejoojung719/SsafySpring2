package com.ssafy.webex.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {


	final String SECRET_KEY = "ssafy";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws Exception {
		
		log.debug("요청 메소드 종류 : {}", request.getMethod());
		
		// OPTIONS 메소드로 넘어오는 preflignt 요청은 true로 넘겨줌.
		if(HttpMethod.OPTIONS.matches(request.getMethod())) {
			return true;
		}

		// 토큰은 헤더에 담겨서 넘겨진다.
		final String token = request.getHeader("access-token");
		
		// 토큰 존재여부 체크
		if(token == null) {
			log.debug("헤더에 access token 정보가 없음");
			response.getWriter().append("not Login");
			return false;
		}
		
		// 토큰의 유효성 체크
		// 토큰 유효성 검사
		try {
			/*Jws<Claims> claims = */Jwts.parser()
			        .setSigningKey(SECRET_KEY.getBytes("UTF-8"))
			        .parseClaimsJws(token);
			log.debug("토큰 존재하고 유효하므로 요청 정상 처리");
			return true;
		} catch (Exception e) {
			log.debug("토큰은 존재하지만 유효하지 않음 : {}", e.getMessage());
			response.getWriter().append("not Login");
			return false;
		}
	}
}
