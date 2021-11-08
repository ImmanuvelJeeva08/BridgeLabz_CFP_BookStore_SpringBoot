package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;

import java.util.List;

public interface ICartService {
    BookDTO addCart(BookDTO bookDTO);

    List<BookDTO> getCart();

    void deleteCart(int id);

}
