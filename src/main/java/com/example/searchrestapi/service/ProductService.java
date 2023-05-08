package com.example.searchrestapi.service;

import com.example.searchrestapi.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> searchProducts(String query);
    ProductDto createProduct(ProductDto productDto);
}
