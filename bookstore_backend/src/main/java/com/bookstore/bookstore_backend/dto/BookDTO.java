package com.bookstore.bookstore_backend.dto;

public record BookDTO(
    String isbn,
    String title,
    String author,
    Double price,
    int stock,
    String text
    ) {
    
}
