package com.example.crudlibary.domain.entity;

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
}
