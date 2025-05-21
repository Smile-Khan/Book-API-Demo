package com.example.bookapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
	@NotBlank(message = "Title is required")
	@Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
	private String title;
	
	@NotBlank(message = "Author is required")
	@Size(min = 2, max = 50, message = "Author must be between 2 and 50 characters")
	private String author;
	
	//Constructor
	public BookDTO() {}
	
	public BookDTO(String title, String author)
	{
		this.title = title;
		this.author = author;
	}
	
	// Getters & Setters
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
}
