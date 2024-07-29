package com.example.crudlibary.repository;

import com.example.crudlibary.domain.entity.Book;
import com.example.crudlibary.dto.BookDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;
import java.util.List;


@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get Book sucessfully from DB")
    void findBookByTitleSucess() {
        BookDTO bookDTO = new BookDTO("1","Harry Potter","J.K. Rowling","Fantasy",1997);
        this.createBook(bookDTO);
        List<Book> foundedBook = this.bookRepository.findBookByTitle(bookDTO.title());
        assertThat(foundedBook).isNotEmpty();
    }

    @Test
    @DisplayName("Should not get Book sucessfully from DB")
    void notFindBookByTitleSucess() {
        BookDTO bookDTO = new BookDTO("1","Harry Potter","J.K. Rowling","Fantasy",1997);
        List<Book> foundedBook = this.bookRepository.findBookByTitle(bookDTO.title());
        assertThat(foundedBook).isEmpty();
    }

    private Book createBook(BookDTO bookDTO){
        Book newBook = new Book(bookDTO);
        this.entityManager.persist(newBook);
        return newBook;
    }


}