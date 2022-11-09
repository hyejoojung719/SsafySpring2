package com.ssafy.webex.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.webex.dto.Car;
import com.ssafy.webex.model.mapper.CarMapper;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarMapper carDao;
	
	@Override
	@Transactional
	public int insert(Car car) throws Exception {
		return carDao.insert(car);
	}

	@Override
	public List<Car> search() throws Exception {
		return carDao.search();
	}

	@Override
	public Car select(String number) throws Exception {
		return carDao.select(number);
	}

	@Override
	@Transactional
	public int update(Car car) throws Exception {
		return carDao.update(car);
	}

	@Override
	@Transactional
	public int delete(String number) throws Exception {
		return carDao.delete(number);
	}

}
