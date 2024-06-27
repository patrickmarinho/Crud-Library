package com.example.crudlibary.repository;

import com.example.crudlibary.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
@DataJpaTest
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByTitle(String title);
    List<Book> findBookByTitle(String title);
}
