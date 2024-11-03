package org.valentine.lab5.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.valentine.lab5.entity.Author;

import java.util.List;

@Repository
@AllArgsConstructor
public class AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveAuthor(Author author) {
        jdbcTemplate.update("INSERT INTO author (first_name, last_name, email, is_active) VALUES (?, ?, ?, ?)",
                author.getFirstName(), author.getLastName(), author.getEmail(), author.isActive());
    }

    public void updateAuthor(Author author) {
        jdbcTemplate.update("UPDATE author SET first_name = ?, last_name = ?, email = ?, is_active = ? WHERE author_id = ?",
                author.getFirstName(), author.getLastName(), author.getEmail(), author.isActive(), author.getAuthorId());
    }

    public Author getAuthor(Long authorId) {
        return jdbcTemplate.queryForObject("SELECT author_id, first_name, last_name, email, is_active FROM author WHERE author_id = ?",
                BeanPropertyRowMapper.newInstance(Author.class), authorId);
    }

    public void deleteAuthor(Long authorId) {
        jdbcTemplate.update("DELETE FROM author WHERE author_id = ?", authorId);
    }

    public void deactivateAuthor(Long authorId) {
        jdbcTemplate.update("UPDATE author SET is_active = ? WHERE author_id = ?", false, authorId);
    }

    public List<Author> getAllAuthors(){
        return jdbcTemplate.query("SELECT author_id, first_name, last_name, email, is_active FROM author",
                BeanPropertyRowMapper.newInstance(Author.class));
    }
}
