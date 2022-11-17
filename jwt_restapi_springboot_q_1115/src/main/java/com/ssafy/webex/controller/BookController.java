package com.ssafy.webex.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.webex.dto.Book;
import com.ssafy.webex.model.service.BookService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
	
	@Autowired
	BookService bookService;
	
	//전체 목록 조회	- GET /book
	@GetMapping
	@ApiOperation(value="전체 조회", response = List.class)
	public ResponseEntity<?> getBookList() throws SQLException{
		List<Book> bookList = bookService.selectAll();
		return new ResponseEntity<List<Book>>( bookList , HttpStatus.OK);
	}
	
	//상세 조회 - GET /book/15
	@GetMapping("/{isbn}")
	public ResponseEntity<?> detailBook(@PathVariable String isbn) throws SQLException{
		
		Book book = bookService.selectByIsbn(isbn);
		
		if(book!=null) return new ResponseEntity<Book>( book,  HttpStatus.OK  );
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//책 정보 등록 - POST /book 
	@PostMapping 
	public ResponseEntity<?> registBook(@RequestBody Book book) throws SQLException{
		
		log.debug("등록할 책 정보 : {}", book.toString());
		
		//DB에 책정보 및 파일 정보 등록
		int cnt = bookService.registBook(book);
		
		//상태 코드만으로 구분
		if(cnt==1) return new ResponseEntity<Void>(HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//책 정보 수정 - PUT /book
	@PutMapping("/{isbn}")
	public ResponseEntity<?> updateBook(@RequestBody Book book) throws SQLException {
		
		int cnt = bookService.updateBook(book);
		
		//상태 코드만으로 구분
		if(cnt==1) return new ResponseEntity<Void>(HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//책 삭제 - DELETE /book/35
	@DeleteMapping("/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable String isbn) throws SQLException {
		
		int cnt = bookService.deleteByIsbn(isbn);
		
		//상태 코드만으로 구분
		if(cnt==1) return new ResponseEntity<Void>(HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
