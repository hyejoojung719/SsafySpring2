package com.ssafy.webex.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.webex.dto.Book;
import com.ssafy.webex.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookDao;
	
	@Override
	@Transactional
	public int insert(Book book) throws Exception {
		return bookDao.insert(book);
	}

	@Override
	public List<Book> selectAll() throws Exception {
		return bookDao.selectAll();
	}

	@Override
	public Book selectByIsbn(String isbn) throws Exception {
		return bookDao.selectByIsbn(isbn);
	}

	@Override
	@Transactional
	public int update(Book book) throws Exception {
		return bookDao.update(book);
	}

	@Override
	@Transactional
	public int deleteByIsbn(String isbn) throws Exception {
		return bookDao.deleteByIsbn(isbn);
	}

}
