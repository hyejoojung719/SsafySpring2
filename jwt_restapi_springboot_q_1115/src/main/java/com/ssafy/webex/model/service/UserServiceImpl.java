package com.ssafy.webex.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.webex.dto.User;
import com.ssafy.webex.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User login(User user) throws SQLException {
		return userMapper.login(user);
	}

}
