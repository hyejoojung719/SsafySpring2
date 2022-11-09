package com.ssafy.webex.model.service;

import java.util.List;

import com.ssafy.webex.dto.Car;

public interface CarService {

	int insert(Car car) throws Exception;

	List<Car> search() throws Exception;

	Car select(String number) throws Exception;

	int update(Car car) throws Exception;

	int delete(String number) throws Exception;

}
