package com.ssafy.webex.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.webex.dto.Book;
import com.ssafy.webex.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<Book> selectAll() throws SQLException {
		return bookMapper.selectAll();
	}

	@Override
	public int registBook(Book book) throws SQLException {
		return bookMapper.registBook(book);
	}

	@Override
	public Book selectByIsbn(String isbn) throws SQLException {
		return bookMapper.selectByIsbn(isbn);
	}

	@Override
	public int updateBook(Book book) throws SQLException {
		return bookMapper.updateBook(book);
	}

	@Override
	public int deleteByIsbn(String isbn) throws SQLException {
		return bookMapper.deleteByIsbn(isbn);
	}

}
