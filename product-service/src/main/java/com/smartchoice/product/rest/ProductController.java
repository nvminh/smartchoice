package com.smartchoice.product.rest;

import com.smartchoice.common.dto.ProductAddDto;
import com.smartchoice.common.dto.ProductDetailsDto;
import com.smartchoice.common.dto.ProductDto;
import com.smartchoice.common.dto.SearchDto;
import com.smartchoice.product.entity.LogEvent;
import com.smartchoice.product.service.AuditLogService;
import com.smartchoice.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    private final ProductService productService;
    private final AuditLogService auditLogService;

    public ProductController(@Autowired ProductService productService, AuditLogService auditLogService) {
        this.productService = productService;
        this.auditLogService = auditLogService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProductDto>> search(@RequestBody SearchDto search, HttpServletRequest request) {
        auditLogService.log(LogEvent.CUSTOMER_SEARCH, request.getRemoteHost(), search.toString());
        return ResponseEntity.ok(productService.search(search));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody ProductAddDto product) {
        productService.addProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailsDto> getProductDetails(@PathVariable("productId") Long productId) {
        Optional<ProductDetailsDto> productDetailsDto = productService.getProductDetails(productId);
        return productDetailsDto.isPresent() ? ResponseEntity.ok(productDetailsDto.get()) : ResponseEntity.noContent().build();
    }
}
