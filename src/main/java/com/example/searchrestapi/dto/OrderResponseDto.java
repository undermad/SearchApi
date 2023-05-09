package com.example.searchrestapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private String trackingNumber;
    private String status;
    private String message;
}
