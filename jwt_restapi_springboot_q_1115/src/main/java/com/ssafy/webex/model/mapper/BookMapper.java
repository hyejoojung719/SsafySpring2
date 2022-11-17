package com.ssafy.webex.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.webex.dto.Book;

public interface BookMapper {
	List<Book> selectAll() throws SQLException;

	int registBook(Book book) throws SQLException;
	
	Book selectByIsbn(String isbn) throws SQLException;
	
	int updateBook(Book book) throws SQLException;
	
	int deleteByIsbn(String isbn) throws SQLException;
	
}
