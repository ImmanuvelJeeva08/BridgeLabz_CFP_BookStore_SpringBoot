package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.dto.WishDTO;

import java.util.List;

public interface IWishListService {
    WishDTO addWish(WishDTO bookDTO);

    List<WishDTO> getWish();

    void deleteWish(int id);
}
