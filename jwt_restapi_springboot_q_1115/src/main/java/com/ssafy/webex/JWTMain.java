package com.ssafy.webex;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTMain {
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {

		
		final int EXPIRE_MINUTES = 5;
        final String SECRET_KEY = "ssafy";
        
        String token = Jwts.builder()
            //header
            .setHeaderParam("typ", "JWT")
            .setHeaderParam("alg", "HS256")
            //payload
            .claim("id", "hyejoo")
            .claim("name", "정혜주")
            .setExpiration(new Date(System.currentTimeMillis() + 1000*EXPIRE_MINUTES))
            //signature
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes("UTF-8"))
            .compact();
        
        log.debug("토큰 : {}", token);
        
        Thread.sleep(7000);	// 만료 시간은 5초니까 이후에 실행되면 만료
        // 디코딩
        log.debug(new String(Base64.getDecoder().decode(token.split("\\.")[1])));
        
        // 토큰 유효성 검사
        Jws<Claims> claims = Jwts.parser()
        .setSigningKey(SECRET_KEY.getBytes("UTF-8"))
        .parseClaimsJws(token);
        
        log.debug(claims.toString());
	}
}
