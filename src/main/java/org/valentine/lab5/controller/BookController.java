package org.valentine.lab5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.valentine.lab5.entity.Book;
import org.valentine.lab5.service.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    @PutMapping
    public void updateBook(Book book) {
        bookService.updateBook(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }
}

