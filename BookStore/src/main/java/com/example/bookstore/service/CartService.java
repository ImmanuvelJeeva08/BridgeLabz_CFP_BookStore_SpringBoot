package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Cart;
import com.example.bookstore.exception.BookStoreException;
import com.example.bookstore.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDTO addCart(BookDTO bookDTO) {
        Cart addDetails = modelMapper.map(bookDTO, Cart.class);
        cartRepository.save(addDetails);
        return bookDTO;
    }

    @Override
    public List<BookDTO> getCart() {
        return cartRepository.findAll().stream().map(book -> {
            return new BookDTO(book.getBookId(), book.getBookDetails(), book.getAuthorName(), book.getBookName(),
                    book.getPrice(), book.getNoOfBooks() ,book.getImage() );
        }).collect(Collectors.toList());
    }

    public Cart findBookById(int id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new BookStoreException("Unable to find any Cart detail!"));
    }


    @Override
    public void deleteCart(int id) {
        if (id > 0) {
            Cart cart = findBookById(id);
            cartRepository.delete(cart);
        }
    }
}
