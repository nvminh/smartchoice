package com.smartchoice.consumer.service;

import com.smartchoice.common.dto.ProductPriceDto;

public interface PriceCollector {
    ProductPriceDto getPrice(Long productId);
}
