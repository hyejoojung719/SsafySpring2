package com.ssafy.webex.model.mapper;

import java.sql.SQLException;

import com.ssafy.webex.dto.User;

public interface UserMapper {

	User login(User user) throws SQLException;
	
}
