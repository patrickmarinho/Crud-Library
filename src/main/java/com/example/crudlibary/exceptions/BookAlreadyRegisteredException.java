package com.example.crudlibary.exceptions;

public class BookAlreadyRegisteredException extends RuntimeException{
    public BookAlreadyRegisteredException(){super("This book has already been registered.");}
    public BookAlreadyRegisteredException(String message){super(message);}
}
