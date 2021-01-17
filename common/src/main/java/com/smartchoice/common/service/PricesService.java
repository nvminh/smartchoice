package com.smartchoice.common.service;

import com.smartchoice.common.dto.ProductPriceDto;

import java.util.List;

public interface PricesService {
    List<ProductPriceDto> getPrices(Long productId);
}
