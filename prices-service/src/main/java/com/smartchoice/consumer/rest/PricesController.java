package com.smartchoice.consumer.rest;

import com.smartchoice.common.dto.ProductPriceDto;
import com.smartchoice.common.service.PricesService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PricesController {
    private PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping
    @Cacheable(value = "prices", key = "#productId")
    public ResponseEntity<List<ProductPriceDto>> getPrices(@RequestParam Long productId) {
        return ResponseEntity.ok(pricesService.getPrices(productId));
    }
}
