package com.example.bookapi.controller;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.dto.PagedResponse;
import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Get all books with optional search filtering by title and author,
     * and pagination support.
     * Example: GET /api/books?title=java&author=smith&page=0&size=5
     */
    @GetMapping
    public ResponseEntity<PagedResponse<BookDTO>> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("GET /api/books called - title: {}, author: {}, page: {}, size: {}", title, author, page, size);

        // Default empty string for null params to match all
        String titleFilter = title == null ? "" : title;
        String authorFilter = author == null ? "" : author;

        Page<Book> bookPage = bookService.searchBooks(titleFilter, authorFilter, PageRequest.of(page, size));

        List<BookDTO> dtos = bookPage.stream()
                .map(Book::toDTO)
                .collect(Collectors.toList());

        PagedResponse<BookDTO> response = new PagedResponse<>(
                dtos,
                bookPage.getNumber(),
                bookPage.getSize(),
                bookPage.getTotalElements(),
                bookPage.getTotalPages(),
                bookPage.isLast()
        );

        return ResponseEntity.ok(response);
    }

    // Add new book
    @PostMapping
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
        log.info("POST /api/books called - adding book: {}", bookDTO);
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setYear(bookDTO.getYear());
        Book saved = bookService.save(book);
        return new ResponseEntity<>(saved.toDTO(), HttpStatus.CREATED);
    }

    // Update book by id
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookDTO bookDTO) {
        log.info("PUT /api/books/{} called - update data: {}", id, bookDTO);
        return bookService.findById(id)
                .map(existing -> {
                    existing.setTitle(bookDTO.getTitle());
                    existing.setAuthor(bookDTO.getAuthor());
                    existing.setPublisher(bookDTO.getPublisher());
                    existing.setYear(bookDTO.getYear());
                    Book updated = bookService.save(existing);
                    return ResponseEntity.ok(updated.toDTO());
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        log.info("DELETE /api/books/{} called", id);
        if (bookService.findById(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
