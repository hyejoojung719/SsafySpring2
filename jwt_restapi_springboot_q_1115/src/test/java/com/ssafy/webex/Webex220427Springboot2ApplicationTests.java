package com.ssafy.webex;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.webex.model.mapper.BookMapper;
import com.ssafy.webex.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Webex220427Springboot2ApplicationTests {

	@Autowired
	BookService bookService;
	
	@Autowired
	BookMapper bookMapper;
	
	@Test
	void contextLoads() {
		log.debug("실행");
	}
	


}
