package com.example.bookstore.controller;

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookStore/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/addOrderDetails")
    public ResponseEntity<ResponseDTO> addOrderDetails(@RequestBody OrderDTO orderDTO, UserDTO userDTO) {
        OrderDTO addData = orderService.addOrder(orderDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added new Order Details", addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @GetMapping(value = "/getOrderDetails")
    public ResponseEntity<ResponseDTO> getOrderDetails() {
        List<OrderDTO> orderData = orderService.getOrderDetails();
        ResponseDTO responseDTO = new ResponseDTO("Fetched All Order Details", orderData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }


}
