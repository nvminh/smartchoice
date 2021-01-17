package com.smartchoice.prices.service.impl;

import com.smartchoice.common.dto.ProductPriceDto;
import com.smartchoice.common.config.ApiConfiguration;
import com.smartchoice.prices.config.PartnerApiConfigurations;
import com.smartchoice.prices.service.PriceCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public abstract class AbstractPriceCollector implements PriceCollector {
    private static final Logger logger = LoggerFactory.getLogger(AbstractPriceCollector.class);

    String partnerId;
    ApiConfiguration apiConfiguration;
    public AbstractPriceCollector(String partnerId, PartnerApiConfigurations configurations) {
        this.partnerId = partnerId;
        this.apiConfiguration = configurations.getConfigurations().get(partnerId);
    }

    @Override
    public ProductPriceDto getPrice(Long productId) {
        ProductPriceDto priceDto = new ProductPriceDto();
        priceDto.setPartnerId(partnerId);
        priceDto.setPrice(new Random(1000).nextFloat());
        logger.info("Get price for product {} from {}", productId, partnerId);
        return priceDto;
    }
}
