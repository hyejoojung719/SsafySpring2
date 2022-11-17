package com.ssafy.webex.dto;


import lombok.Data;

@Data
public class Book {

	private String isbn;
	private String title;
	private String author;
	private int price;
	private String description;
	
}
