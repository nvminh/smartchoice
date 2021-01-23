package com.smartchoice.consumer.service.impl;

import com.smartchoice.consumer.config.PartnerApiConfigurations;
import org.springframework.stereotype.Service;

@Service("tikiPriceCollector")
public class TikiPriceCollectorImpl extends AbstractPriceCollector {
    public TikiPriceCollectorImpl(PartnerApiConfigurations apiConfigurations) {
        super("TIKI", apiConfigurations);
    }
}
