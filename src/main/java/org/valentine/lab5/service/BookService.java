package org.valentine.lab5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.valentine.lab5.entity.Book;
import org.valentine.lab5.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteBook(bookId);
    }

    public Book getBook(Long bookId) {
        return bookRepository.getBook(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
