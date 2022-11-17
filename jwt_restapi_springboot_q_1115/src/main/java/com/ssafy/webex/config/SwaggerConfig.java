package com.ssafy.webex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//swagger 3버전
	//http://localhost{서비스 중인 포트번호}/{context-path}/swagger-ui/index.html
	//http://localhost:8080/webex/swagger-ui/index.html
	
	@Bean
	public Docket api() {
		//api 정보 설정
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("SSAFY 도서관리 API")
				.description("<h3>워크샵에서 사용되는 RestApi에 대한 문서를 제공한다.</h3>")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
				.license("MIT License")
				.version("1.0")
				.build();

		return new Docket(DocumentationType.SWAGGER_2)	//스웨거 타입으로 문서화
				.apiInfo(apiInfo) 						//위에서 설정한 정보를 통해 문서화
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.webex.controller"))	//문서화할 컨트롤러가 있는 패키지
				.paths(PathSelectors.ant("/**/book/**"))	//위 패키지의 컨트롤러에 매핑된 것중 해당 url의 요청만 문서화
//				/webex/book/webe/xbex
//				/book
//				/webex/abddc/book
				.build();
	}
	
}
