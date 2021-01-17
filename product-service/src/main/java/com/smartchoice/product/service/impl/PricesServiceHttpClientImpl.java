package com.smartchoice.product.service.impl;

import com.smartchoice.common.config.ApiConfiguration;
import com.smartchoice.common.dto.ProductPriceDto;
import com.smartchoice.common.service.PricesService;
import com.smartchoice.product.config.InternalApiConfigurations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PricesServiceHttpClientImpl implements PricesService {
    private ApiConfiguration apiConfiguration;
    private RestTemplate restTemplate;

    public PricesServiceHttpClientImpl(InternalApiConfigurations configurations, RestTemplate restTemplate) {
        this.apiConfiguration = configurations.getConfigurations().get("pricesService");
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductPriceDto> getPrices(Long productId) {
        ParameterizedTypeReference<List<ProductPriceDto>> type = new ParameterizedTypeReference<List<ProductPriceDto>>() {};
        ResponseEntity<List<ProductPriceDto>> responseEntity = restTemplate.exchange(apiConfiguration.getUrl(), HttpMethod.GET, null, type, productId);
        return responseEntity.getBody();
    }
}
