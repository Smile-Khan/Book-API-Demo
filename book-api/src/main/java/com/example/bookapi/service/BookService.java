package com.example.bookapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookapi.dto.BookDTO;
import com.example.bookapi.model.Book;

@Service
public class BookService {
	private final List<Book> bookStore = new ArrayList<>();

    public void addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), "AUTO-GEN-ISBN", 2024);
        bookStore.add(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookStore.stream()
                        .map(Book::toDTO)
                        .toList();
}
    public List<BookDTO> searchBooksByAuthor(String authorQuery) {
        return bookStore.stream()
                .filter(book -> book.getAuthor() != null &&
                        book.getAuthor().toLowerCase().contains(authorQuery.toLowerCase()))
                .map(Book::toDTO)
                .toList();
    }

}
