package com.smartchoice.prices.service.impl;

import com.smartchoice.prices.config.PartnerApiConfigurations;
import org.springframework.stereotype.Service;

@Service("tikiPriceCollector")
public class TikiPriceCollectorImpl extends AbstractPriceCollector {
    public TikiPriceCollectorImpl(PartnerApiConfigurations apiConfigurations) {
        super("TIKI", apiConfigurations);
    }
}
