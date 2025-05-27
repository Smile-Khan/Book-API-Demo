package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Save or update book
    public Book save(Book book) {
        Book saved = bookRepository.save(book);
        log.info("Book saved/updated: {}", saved);
        return saved;
    }

    // Get all books with pagination
    public Page<Book> findAll(Pageable pageable) {
        log.info("Fetching all books with pagination: {}", pageable);
        return bookRepository.findAll(pageable);
    }

    // Search books by title and author with pagination
    public Page<Book> searchBooks(String title, String author, Pageable pageable) {
        log.info("Searching books by title '{}' and author '{}' with pagination: {}", title, author, pageable);
        return bookRepository.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title, author, pageable);
    }

    // Find book by ID
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    // Delete book by ID
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
        log.info("Book deleted with id: {}", id);
    }
}
