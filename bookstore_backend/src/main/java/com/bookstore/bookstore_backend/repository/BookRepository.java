package com.bookstore.bookstore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore_backend.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
    
}
