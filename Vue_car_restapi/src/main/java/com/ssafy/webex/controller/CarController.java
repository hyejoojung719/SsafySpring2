package com.ssafy.webex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.webex.dto.Car;
import com.ssafy.webex.model.service.CarService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/car")
@CrossOrigin("*")
public class CarController {

	
	@Autowired
	CarService carService;
	
	//1. Create 등록
	//데이터 등록 요청
	@PostMapping
	@ApiOperation(value = "차 정보 등록. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환", response = String.class)
	public ResponseEntity<?> doRegist(@RequestBody Car car) throws Exception {
		int result = carService.insert(car);
		
		//상태 코드만으로 구분
		if(result==1) return new ResponseEntity<Void>(HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//2. Read 조회
	//전체  목록 조회
	@GetMapping
	@ApiOperation(value = "모든 차의 정보를 반환", response = List.class)
	public ResponseEntity<?> showList() throws Exception {
		
		List<Car> cars = carService.search();
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	//상세 조회
	@GetMapping("/{number}")
	@ApiOperation(value = "number에 해당하는 차의 정보를 반환한다.", response = Car.class)
	public ResponseEntity<?> showDetail(@PathVariable String number) throws Exception {
		
		Car car = carService.select(number);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	
	//3. Update 수정
	//데이터 수정 요청
	@PutMapping("/{number}")
	@ApiOperation(value = "number에 해당하는 차의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환", response = String.class)
	public ResponseEntity<?> modifyBook(@RequestBody Car car) throws Exception {
		int result = carService.update(car);
		
		//상태 코드만으로 구분
		if(result==1) return new ResponseEntity<Void>(HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//4. Delete 삭제
	@DeleteMapping("/{number}")
	@ApiOperation(value = "number에 해당하는 차의 정보 삭제. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열 반환", response = String.class)
	public ResponseEntity<?> doDelete(@PathVariable String number) throws Exception {
		int result = carService.delete(number);
		
		//상태 코드만으로 구분
		if(result==1) return new ResponseEntity<Void>(HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
