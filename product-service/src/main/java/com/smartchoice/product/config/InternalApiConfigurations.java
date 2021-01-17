package com.smartchoice.product.config;

import com.smartchoice.common.config.ApiConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "internal.api")
@Getter
@Setter
public class InternalApiConfigurations {
    private Map<String, ApiConfiguration> configurations;
}
