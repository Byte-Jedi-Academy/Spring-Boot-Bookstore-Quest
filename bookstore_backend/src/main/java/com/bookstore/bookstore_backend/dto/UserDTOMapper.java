package com.bookstore.bookstore_backend.dto;


import org.springframework.stereotype.Component;

import com.bookstore.bookstore_backend.model.User;

@Component
public class UserDTOMapper{

    public UserDTO convert(User user){
        return new UserDTO(user.getName(), user.getSurName(), user.getEmail(), user.getPassword(), user.getAddress());
    }
}
