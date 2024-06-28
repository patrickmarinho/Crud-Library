package com.example.crudlibary.domain.entity;

import com.example.crudlibary.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name="book")
@Entity(name ="book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties(ignoreUnknown = false)
public class Book {
    @Id @NotNull @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull @NotBlank
    private String title;

    @NotNull @NotBlank
    private String author;

    @NotNull @NotBlank
    private String category;

    @NotNull
    private Integer publication_year;

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.title();
        this.author = bookDTO.author();
        this.category = bookDTO.category();
        this.publication_year = bookDTO.publication_year();
    }

}
