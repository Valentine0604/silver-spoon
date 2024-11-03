package org.valentine.lab5.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.valentine.lab5.entity.Author;
import org.valentine.lab5.service.AuthorService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @PutMapping
    public void updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
    }

    @GetMapping("/{authorId}")
    public Author getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PatchMapping("/deactivate/{authorId}")
    public void deactivateAuthor(@PathVariable Long authorId) {
        authorService.deactivateAuthor(authorId);
    }
}
