package com.example.searchrestapi.controller;

import com.example.searchrestapi.dto.OrderRequest;
import com.example.searchrestapi.dto.OrderResponseDto;
import com.example.searchrestapi.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println(orderRequest.getOrder().getTotalQuantity());
        System.out.println(orderRequest.getOrder().getTotalPrice());
        System.out.println(orderRequest.getOrder().getShoppingCartId());
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
