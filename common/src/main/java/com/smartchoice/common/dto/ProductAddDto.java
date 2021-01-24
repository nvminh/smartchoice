package com.smartchoice.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductAddDto {
    private String name;
    private List<String> images;
}
