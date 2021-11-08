package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.entity.User;

import java.util.List;

public interface IUserService {
    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getUserDetails();

    UserDTO updateUser(int id, UserDTO userDTO);

    void deleteUser(int id);

    User getUserContact(String email, String password);
}
