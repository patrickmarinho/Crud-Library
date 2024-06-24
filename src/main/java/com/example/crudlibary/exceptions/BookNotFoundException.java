package com.example.crudlibary.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {super("Book not found.");}
    public BookNotFoundException(String message) {super(message);}
}
