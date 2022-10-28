package com.ssafy.rest.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.rest.dto.Book;

public interface BookService {

	// 전체 조회
	List<Book> selectAll() throws SQLException;

	// 등록
	int insertBook(Book book) throws SQLException;

}
