package com.bookstore.bookstore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore_backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
