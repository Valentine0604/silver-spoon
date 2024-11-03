package org.valentine.lab5.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.valentine.lab5.entity.Book;

import java.util.List;

@Repository
@AllArgsConstructor
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveBook(Book book) {
        jdbcTemplate.update("INSERT INTO book (title, author, publication_year, publisher) VALUES (?, ?, ?, ?)", book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getPublisher());
    }

    public void updateBook(Book book) {
        jdbcTemplate.update("UPDATE book SET title = ?, author = ?, publication_year = ?, publisher = ? WHERE book_id = ?", book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getPublisher(), book.getBookId());
    }

    public Book getBook(Long bookId) {
        return jdbcTemplate.queryForObject("SELECT book_id, title, author, publication_year, publisher FROM book WHERE book_id = ?", BeanPropertyRowMapper.newInstance(Book.class), bookId);
    }

    public void deleteBook(Long bookId) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id = ?", bookId);
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT book_id, title, author, publication_year, publisher FROM book", BeanPropertyRowMapper.newInstance(Book.class));
    }
}
