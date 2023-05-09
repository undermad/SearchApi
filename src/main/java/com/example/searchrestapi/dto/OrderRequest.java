package com.example.searchrestapi.dto;

import com.example.searchrestapi.entity.Order;
import com.example.searchrestapi.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;
}
