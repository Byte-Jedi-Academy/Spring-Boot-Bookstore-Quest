package com.bookstore.bookstore_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    private Double price;
    private int stock;
    private String text;

    // Getters and Setters

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    // Constructors

    public Book() {
        
    }
    

    public Book(String isbn, String title, String author, Double price, int stock, String text) {
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.price=price;
        this.stock=stock;
        this.text=text;
    }

    public static class Builder{
        @Id
        private String isbn;
        private String title;
        private String author;
        private Double price;
        private int stock;
        private String text;

        public Builder() {
        }


        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Book build(){
            return new Book(isbn, title, author, price, stock, text);
        }
    }

}
