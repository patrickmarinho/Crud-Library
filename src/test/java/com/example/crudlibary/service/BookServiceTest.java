package com.example.crudlibary.service;

import com.example.crudlibary.domain.entity.Book;
import com.example.crudlibary.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doReturn;


//@DataJpaTest
@ActiveProfiles("test")
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Autowired
    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return all books saved in database")
    void getBooks() {

        //Arrange
        Book book = new Book("1","Harry Potter","J.K. Rowling","Fantasy",1997);
        List<Book> books = Collections.singletonList(book);
        doReturn(books).when(bookRepository).findAll();

        //Act
        List<Book> bookList = bookService.getBooks();

        //Assert
        Assertions.assertEquals(book,books.get(0));
    }

    @Test
    @DisplayName("Should return all books that have the same name as the input")
    void getBookByTitle() {
        //Arrange
        Book book = new Book("1","The Silmarillion","J.R.R. Tolkien","Fantasy",1977);
        List<Book> books = Collections.singletonList(book);
        doReturn(books).when(bookRepository).findBookByTitle(book.getTitle());

        //Act
        List<Book> bookList = bookService.getBookByTitle(book.getTitle());

        //Assert
        Assertions.assertEquals(book, books.get(0));

    }

    @Test
    @DisplayName("Should save the book in the database")
    void saveBook() {
        //Arrange
        Book book = new Book("1","The Silmarillion","J.R.R. Tolkien","Fantasy",1977);
        doReturn(book).when(bookRepository).save(book);

        //Act
        Book savedBook = bookService.saveBook(book);


        //Assert
        System.out.println(savedBook);
    }

    @Test
    @DisplayName("Should update the book in the database")
    void updateBook() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("Should delete the book from the database")
    void deleteBook() {
        //Arrange

        //Act

        //Assert

    }

}