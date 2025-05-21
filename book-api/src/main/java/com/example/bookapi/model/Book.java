package com.example.bookapi.model;

import com.example.bookapi.dto.BookDTO;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getYear() { return year; }

    public BookDTO toDTO() {
        return new BookDTO(this.title, this.author);
    }
}
