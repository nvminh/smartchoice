package com.smartchoice.prices.service.impl;

import com.smartchoice.common.dto.ProductPriceDto;
import com.smartchoice.prices.service.PriceCollector;
import com.smartchoice.common.service.PricesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricesServiceImpl implements PricesService {
    private final List<PriceCollector> priceCollectors;

    public PricesServiceImpl(List<PriceCollector> priceCollectors) {
        this.priceCollectors = priceCollectors;
    }

    @Override
    public List<ProductPriceDto> getPrices(Long productId) {
        return priceCollectors.parallelStream().map(i->i.getPrice(productId)).collect(Collectors.toList());
    }
}
