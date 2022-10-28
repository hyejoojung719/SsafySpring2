package com.ssafy.rest.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.rest.dto.Book;

// @Mapper 할 필요 X
public interface BookMapper {

	// 전체 조회
	List<Book> selectAll() throws SQLException;
	
	// 등록
	int insertBook(Book book) throws SQLException;
	
	
}
