package com.smartchoice.consumer.service.impl;

import com.smartchoice.consumer.config.PartnerApiConfigurations;
import org.springframework.stereotype.Service;

@Service("shopeePriceCollector")
public class ShopeePriceCollectorImpl extends AbstractPriceCollector {
    public ShopeePriceCollectorImpl(PartnerApiConfigurations apiConfigurations) {
        super("SHOPEE", apiConfigurations);
    }
}
