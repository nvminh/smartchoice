package com.smartchoice.product.service;

import com.smartchoice.common.dto.ProductAddDto;
import com.smartchoice.common.dto.ProductDetailsDto;
import com.smartchoice.common.dto.ProductDto;
import com.smartchoice.common.dto.SearchDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> search(SearchDto search);
    void addProduct(ProductAddDto product);
    Optional<ProductDetailsDto> getProductDetails(Long productId);
}
