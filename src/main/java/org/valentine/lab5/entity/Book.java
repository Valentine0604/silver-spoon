package org.valentine.lab5.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long bookId;
    private String title;
    private String author;
    private String publicationYear;
    private String publisher;
}
