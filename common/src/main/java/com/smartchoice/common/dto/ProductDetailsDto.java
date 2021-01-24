package com.smartchoice.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDetailsDto {
    private ProductDto product;
    private List<ProductPriceDto> prices;
    private List<String> images;
}
