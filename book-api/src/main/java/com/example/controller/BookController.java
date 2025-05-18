package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.Book;

import java.util.List;
import java.util.Arrays;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks() {
        return Arrays.asList(
            new Book("The Hobbit", "J.R.R. Tolkien", "978-0261103344", 1937),
            new Book("1984", "George Orwell", "978-0451524935", 1949),
            new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", 1960)
        );
    }
}
