package com.smartchoice.consumer.config;

import com.smartchoice.common.config.ApiConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "partner.api")
@Getter
@Setter
public class PartnerApiConfigurations {
    private Map<String, ApiConfiguration> configurations;
}
