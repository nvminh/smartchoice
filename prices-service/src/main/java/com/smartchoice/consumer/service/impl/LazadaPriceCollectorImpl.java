package com.smartchoice.consumer.service.impl;

import com.smartchoice.consumer.config.PartnerApiConfigurations;
import org.springframework.stereotype.Service;

@Service("lazadaPriceCollector")
public class LazadaPriceCollectorImpl extends AbstractPriceCollector {
    public LazadaPriceCollectorImpl(PartnerApiConfigurations apiConfigurations) {
        super("LAZADA", apiConfigurations);
    }
}
