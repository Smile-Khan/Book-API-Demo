package com.example.bookapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.service.BookService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;

    // Constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<String> addBook(@Valid @RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.ok("Book added successfully");
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooksByAuthor(
            @RequestParam(name = "author") String author) {

        if (author == null || author.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<BookDTO> result = bookService.searchBooksByAuthor(author.trim());
        return ResponseEntity.ok(result);
    }

}
