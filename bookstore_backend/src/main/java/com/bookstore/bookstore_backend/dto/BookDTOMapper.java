package com.bookstore.bookstore_backend.dto;


import org.springframework.stereotype.Component;

import com.bookstore.bookstore_backend.model.Book;

@Component
public class BookDTOMapper{

    public BookDTO convert(Book book){
        return new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getStock(), book.getText());
    }
    
}
