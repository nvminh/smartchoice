package com.smartchoice.prices.service.impl;

import com.smartchoice.prices.config.PartnerApiConfigurations;
import org.springframework.stereotype.Service;

@Service("shopeePriceCollector")
public class ShopeePriceCollectorImpl extends AbstractPriceCollector {
    public ShopeePriceCollectorImpl(PartnerApiConfigurations apiConfigurations) {
        super("SHOPEE", apiConfigurations);
    }
}
