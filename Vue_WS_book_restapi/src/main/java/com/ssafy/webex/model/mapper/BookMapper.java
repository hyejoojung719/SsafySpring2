package com.ssafy.webex.model.mapper;

import java.util.List;

import com.ssafy.webex.dto.Book;


public interface BookMapper {

	int insert(Book book) throws Exception;

	List<Book> selectAll() throws Exception;

	Book selectByIsbn(String isbn) throws Exception;

	int update(Book book) throws Exception;

	int deleteByIsbn(String isbn) throws Exception;

}
