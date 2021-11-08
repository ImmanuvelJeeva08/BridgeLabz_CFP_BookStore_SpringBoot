package com.example.bookstore.service;

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.entity.Order;
import com.example.bookstore.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order addDetails = modelMapper.map(orderDTO, Order.class);
        orderRepository.save(addDetails);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrderDetails() {

        return orderRepository.findAll().stream().map(order -> {
            return new OrderDTO(order.getOrderId(), order.getUser(),order.getNumberOfBooksOrdered(), order.getTotalPrice());
        }).collect(Collectors.toList());
    }
}
