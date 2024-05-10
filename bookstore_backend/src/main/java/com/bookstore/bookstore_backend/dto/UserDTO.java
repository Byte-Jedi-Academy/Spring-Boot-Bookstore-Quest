package com.bookstore.bookstore_backend.dto;

public record UserDTO(
    String name,
    String surName,
    String email,
    String password,
    String address
) {
    
}
