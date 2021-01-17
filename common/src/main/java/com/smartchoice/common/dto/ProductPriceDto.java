package com.smartchoice.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceDto {
    private String partnerId;
    private float price;
    private float discountRate;
    private String promotion;
}
