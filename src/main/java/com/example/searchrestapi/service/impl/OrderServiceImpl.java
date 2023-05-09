package com.example.searchrestapi.service.impl;

import com.example.searchrestapi.dto.OrderRequest;
import com.example.searchrestapi.dto.OrderResponseDto;
import com.example.searchrestapi.entity.Order;
import com.example.searchrestapi.entity.Payment;
import com.example.searchrestapi.exception.PaymentException;
import com.example.searchrestapi.repository.OrderRepository;
import com.example.searchrestapi.repository.PaymentRepository;
import com.example.searchrestapi.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional()
    public OrderResponseDto placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("In progress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("DEBIT card is not supported.");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setTrackingNumber(order.getOrderTrackingNumber());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setMessage("SUCCESS");

        return orderResponseDto;
    }
}
