package com.bookstore.bookstore_backend.service;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore_backend.dto.UserDTO;
import com.bookstore.bookstore_backend.dto.UserDTOMapper;
import com.bookstore.bookstore_backend.model.User;
import com.bookstore.bookstore_backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    
    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public UserDTO createUser(UserDTO userRequest){
        User user = new User(userRequest.name(),userRequest.surName(),userRequest.email(),userRequest.password(),userRequest.address());
        return userDTOMapper.convert(userRepository.save(user));
    }
    public UserDTO getUserById(long id){
        return userDTOMapper.convert(findUserById(id));
    }
    public UserDTO updateUser(long id, UserDTO userRequest){
        User user = new User(id,
        userRequest.name(),
        userRequest.surName(),
        userRequest.email(),
        userRequest.password(),
        userRequest.address());

        return userDTOMapper.convert(userRepository.save(user));
    }
    public User findUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public void loginUser(){
        //TODO 
    }
}
