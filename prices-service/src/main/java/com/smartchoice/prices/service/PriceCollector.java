package com.smartchoice.prices.service;

import com.smartchoice.common.dto.ProductPriceDto;

public interface PriceCollector {
    ProductPriceDto getPrice(Long productId);
}
