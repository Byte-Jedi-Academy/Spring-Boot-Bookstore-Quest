package com.bookstore.bookstore_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.bookstore_backend.model.Book;

@SpringBootApplication
public class BookstoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreBackendApplication.class, args);
		Book book = new Book.Builder()
					.isbn("Deneme")
					.title("Deneme")
					.author("deneme")
					.price(0.0)
					.stock(5)
					.text("Denemee")
					.build();
	}

}
