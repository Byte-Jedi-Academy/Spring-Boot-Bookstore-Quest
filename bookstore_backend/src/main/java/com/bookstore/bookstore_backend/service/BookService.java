package com.bookstore.bookstore_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore_backend.dto.BookDTO;
import com.bookstore.bookstore_backend.dto.BookDTOMapper;
import com.bookstore.bookstore_backend.dto.UpdateBookRequest;
import com.bookstore.bookstore_backend.exception.BookNotFoundException;
import com.bookstore.bookstore_backend.model.Book;
import com.bookstore.bookstore_backend.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDTOMapper bookDTOMapper;

    public BookService(BookRepository bookRepository, BookDTOMapper bookDTOMapper) {
        this.bookRepository = bookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }


    public BookDTO createBook(BookDTO bookRequest){
        Book book = new Book(bookRequest.isbn(),bookRequest.title(),bookRequest.author(),bookRequest.price(),bookRequest.stock(),bookRequest.text());
        return bookDTOMapper.convert(bookRepository.save(book));
    }
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }
    public BookDTO updateBook(String isbn, UpdateBookRequest bookRequest){
        Book book = new Book(isbn,
        bookRequest.title(),
        bookRequest.author(),
        bookRequest.price(),
        bookRequest.stock(),
        bookRequest.text()
        );
        return bookDTOMapper.convert(bookRepository.save(book));
    }
    public BookDTO getByIsbn(String isbn){
        return bookDTOMapper.convert(findBookByIsbn(isbn));
        
    }
    public List<BookDTO> getAllBooksList(){
        return bookRepository.findAll().stream().map(bookDTOMapper::convert).collect(Collectors.toList());
    }
    public int getStock(String isbn){
        return findBookByIsbn(isbn).getStock();
    }

    public Book findBookByIsbn(String isbn){
        return bookRepository.findById(isbn).orElseThrow(() -> new BookNotFoundException(""));
    }
}
