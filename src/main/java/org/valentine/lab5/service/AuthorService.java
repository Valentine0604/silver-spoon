package org.valentine.lab5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.valentine.lab5.entity.Author;
import org.valentine.lab5.repository.AuthorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.saveAuthor(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.updateAuthor(author);
    }

    public Author getAuthor(Long authorId) {
        return authorRepository.getAuthor(authorId);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteAuthor(authorId);
    }

    public void deactivateAuthor(Long authorId) {
        authorRepository.deactivateAuthor(authorId);
    }
}
