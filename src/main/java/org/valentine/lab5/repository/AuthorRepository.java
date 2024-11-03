package org.valentine.lab5.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.valentine.lab5.entity.Author;

import java.util.List;

@Repository
public class AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public AuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAuthor(Author author) {
        jdbcTemplate.update("INSERT INTO author (first_name, last_name, email, is_active) VALUES (?, ?, ?, ?)", author.getFirstName(), author.getLastName(), author.getEmail(), author.isActive());
    }

    public void updateAuthor(Author author) {
        jdbcTemplate.update("UPDATE author SET first_name = ?, last_name = ?, email = ?, is_active = ? WHERE id = ?", author.getFirstName(), author.getLastName(), author.getEmail(), author.isActive(), author.getAuthorId());
    }

    public Author getAuthor(Long authorId) {
        return jdbcTemplate.queryForObject("SELECT id, first_name, last_name, email, is_active FROM author WHERE id = ?", BeanPropertyRowMapper.newInstance(Author.class));
    }

    public void deleteAuthor(Long authorId) {
        jdbcTemplate.update("DELETE FROM author WHERE id = ?", authorId);
    }

    public void deactivateAuthor(Long authorId) {
        jdbcTemplate.update("UPDATE clients SET active = ? WHERE id = ?", false, authorId);
    }

    public List<Author> getAllAuthors(){
        return jdbcTemplate.query("SELECT id, first_name, last_name, email, is_active FROM author", BeanPropertyRowMapper.newInstance(Author.class));
    }
}


