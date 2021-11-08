package com.example.bookstore.service;

import com.example.bookstore.dto.WishDTO;
import com.example.bookstore.entity.Wish;
import com.example.bookstore.exception.BookStoreException;
import com.example.bookstore.repository.WishListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishListService implements IWishListService{
    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public WishDTO addWish(WishDTO bookDTO) {
        Wish addDetails = modelMapper.map(bookDTO, Wish.class);
        wishListRepository.save(addDetails);
        return bookDTO;
    }

    @Override
    public List<WishDTO> getWish() {
        return wishListRepository.findAll().stream().map(book -> {
            return new WishDTO(book.getBookId(), book.getBookDetails(), book.getAuthorName(), book.getBookName(),
                    book.getPrice(), book.getNoOfBooks() ,book.getImage() );
        }).collect(Collectors.toList());
    }

    public Wish findBookById(int id) {
        return wishListRepository.findById(id)
                .orElseThrow(() -> new BookStoreException("Unable to find any WishList detail!"));
    }


    @Override
    public void deleteWish(int id) {
        if (id > 0) {
            Wish wishList = findBookById(id);
            wishListRepository.delete(wishList);
        }
    }
}
