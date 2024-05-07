package com.bookstore.bookstore_backend.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bookstore.bookstore_backend.components.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne
    @JoinColumn(name="book_isbn", referencedColumnName = "isbn")
    private Book bookIsbn;

    private int piece;
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date orderDate;
    private OrderStatus orderStatus;

    // Getters and Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }
    public Book getBookIsbn() {
        return bookIsbn;
    }
    public void setBookIsbn(Book bookIsbn) {
        this.bookIsbn = bookIsbn;
    }
    public int getPiece() {
        return piece;
    }
    public void setPiece(int piece) {
        this.piece = piece;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    //Constroctors

    public Order() {
    }
    public Order(User userId, Book bookIsbn, int piece, Date orderDate, OrderStatus orderStatus) {
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.piece = piece;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
    public Order(long id, User userId, Book bookIsbn, int piece, Date orderDate, OrderStatus orderStatus) {
        this.id = id;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.piece = piece;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public static class Builder{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    
        private User userId;
        private Book bookIsbn;
        private int piece;
        private Date orderDate;
        private OrderStatus orderStatus;

        public Builder() {
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder userId(User userId) {
            this.userId = userId;
            return this;
        }
        public Builder bookIsbn(Book bookIsbn) {
            this.bookIsbn = bookIsbn;
            return this;
        }
        public Builder piece(int piece) {
            this.piece = piece;
            return this;
        }
        public Builder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        public Builder orderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Order build(){
            return new Order(userId,bookIsbn,piece,orderDate,orderStatus);
        }

        
    }


}
