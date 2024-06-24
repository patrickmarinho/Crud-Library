package com.example.crudlibary.exceptions;

import jdk.jfr.Experimental;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    private ResponseEntity<String> handleBookNotFoundException(BookNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
    }

    @ExceptionHandler(BookAlreadyRegisteredException.class)
    private ResponseEntity<String> handleBookAlreadyRegisteredException(BookAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This book has already been registered.");
    }
}
