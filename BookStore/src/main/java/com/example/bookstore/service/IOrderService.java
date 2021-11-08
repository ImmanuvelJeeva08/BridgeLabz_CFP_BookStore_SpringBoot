package com.example.bookstore.service;

import com.example.bookstore.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO addOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderDetails();

}
