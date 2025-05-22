package com.example.bookapi.controller;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.model.Book;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        log.info("GET /api/books called - returning all books");
        List<BookDTO> dtos = books.stream()
            .map(Book::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
        log.info("POST /api/books called - adding book: {}", bookDTO);
        Book newBook = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), "N/A", 0);
        books.add(newBook);
        return new ResponseEntity<>(newBook.toDTO(), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam("title") String title) {
        log.info("GET /api/books/search called - searching for title containing '{}'", title);
        List<BookDTO> result = books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
            .map(Book::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
