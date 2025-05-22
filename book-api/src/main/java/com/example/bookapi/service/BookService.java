package com.example.bookapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.model.Book;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

    private final List<Book> bookStore = new ArrayList<>();

    // Adds a new book to the in-memory store
    public void addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), "AUTO-GEN-ISBN", 2024);
        bookStore.add(book);
        log.info("Book added: {}", book);
    }

    // Returns all books as DTOs
    public List<BookDTO> getAllBooks() {
        log.info("Fetching all books, total: {}", bookStore.size());
        return bookStore.stream()
                        .map(Book::toDTO)
                        .toList();
    }

    // Searches books by author name (case-insensitive, partial match)
    public List<BookDTO> searchBooksByAuthor(String authorQuery) {
        log.info("Searching books with author containing: {}", authorQuery);
        List<BookDTO> results = bookStore.stream()
                .filter(book -> book.getAuthor() != null &&
                        book.getAuthor().toLowerCase().contains(authorQuery.toLowerCase()))
                .map(Book::toDTO)
                .toList();
        log.info("Found {} books matching author query '{}'", results.size(), authorQuery);
        return results;
    }
}
