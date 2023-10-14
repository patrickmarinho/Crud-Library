package com.example.crudlibary.controller;

import com.example.crudlibary.domain.entity.Book;
import com.example.crudlibary.repository.BookRepository;
import com.example.crudlibary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @PostMapping()
    public List<Book> registerBook(@RequestBody Book book) {
        return  bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public List<Book> updateBook(@PathVariable String id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }


}
