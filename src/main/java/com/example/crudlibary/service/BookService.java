package com.example.crudlibary.service;

import com.example.crudlibary.domain.entity.Book;
import com.example.crudlibary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    //GET
    public List<Book> getBooks(){
        return repository.findAll();
    }

    //POST
    public List<Book> saveBook(Book book){
        Optional<Book> existingBookOptional = repository.findByTitle(book.getTitle());
        if (existingBookOptional.isPresent()) {
            throw new IllegalArgumentException("Livro com o título fornecido já consta no sistema.");
        } else {
            repository.save(book);
        }
        return getBooks();
    }
    //PUT
    public List<Book> updateBook(String id, Book book) {
       Optional<Book> existingBookOptional = repository.findById(id);

        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setCategory(book.getCategory());
            existingBook.setPublication_year(book.getPublication_year());
            repository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Livro com o ID fornecido não encontrado.");
        }
        return getBooks();
    }


    //DELETE
    public List<Book> deleteBook(String id){
        repository.deleteById(id);
        return getBooks();
    }
}
