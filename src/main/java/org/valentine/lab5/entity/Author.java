package org.valentine.lab5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Long authorId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;

}
