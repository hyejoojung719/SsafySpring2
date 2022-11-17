package com.ssafy.webex.model.service;

import java.sql.SQLException;

import com.ssafy.webex.dto.User;

public interface UserService {

	User login(User user) throws SQLException;
	
}
