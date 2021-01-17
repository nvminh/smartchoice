package com.smartchoice.prices.service.impl;

import com.smartchoice.prices.config.PartnerApiConfigurations;
import org.springframework.stereotype.Service;

@Service("lazadaPriceCollector")
public class LazadaPriceCollectorImpl extends AbstractPriceCollector {
    public LazadaPriceCollectorImpl(PartnerApiConfigurations apiConfigurations) {
        super("LAZADA", apiConfigurations);
    }
}
