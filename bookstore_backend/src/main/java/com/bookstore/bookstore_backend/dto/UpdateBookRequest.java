package com.bookstore.bookstore_backend.dto;

public record UpdateBookRequest(    
    String title,
    String author,
    Double price,
    int stock,
    String text
) {
} 
