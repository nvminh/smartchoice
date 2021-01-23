package com.smartchoice.product.rest;

import com.smartchoice.common.dto.ProductAddDto;
import com.smartchoice.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/products")

public class ProductAdminController {

    private final ProductService productService;

    public ProductAdminController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody ProductAddDto product) {
        productService.addProduct(product);
        return ResponseEntity.ok().build();
    }
}
