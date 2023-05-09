package com.example.searchrestapi.service;

import com.example.searchrestapi.dto.OrderRequest;
import com.example.searchrestapi.dto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequest orderRequest);
}
