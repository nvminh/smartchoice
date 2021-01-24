package com.smartchoice.product.service.impl;

import com.smartchoice.common.dto.*;
import com.smartchoice.common.service.PricesService;
import com.smartchoice.product.entity.Content;
import com.smartchoice.product.entity.Product;
import com.smartchoice.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    ProductServiceImpl service;
    ProductRepository productRepository;
    PricesService pricesService;

    @BeforeEach
    public void beforeEach() {
        productRepository = Mockito.mock(ProductRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        pricesService = Mockito.mock(PricesService.class);
        service = new ProductServiceImpl(productRepository, modelMapper, pricesService);
    }

    @Test
    void search() {
        Product product1 = new Product();
        product1.setName("product 1");
        product1.setId(1L);
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setId(2L);

        Mockito.when(productRepository.findByNameContainsIgnoreCase("product")).thenReturn(Arrays.asList(product1, product2));

        SearchDto searchDto = new SearchDto("product");
        List<ProductDto> productDtos = service.search(searchDto);

        assertEquals(2, productDtos.size());
        assertEquals("product 1", productDtos.get(0).getName());
        assertEquals("product 2", productDtos.get(1).getName());
    }

    @Test
    void getProductDetails() {
        Product product1 = new Product();
        product1.setName("product 1");
        product1.setId(1L);
        LinkedHashSet contents = new LinkedHashSet();
        Content content = new Content();
        content.setContentType(ContentType.IMAGE);
        content.setPath("image1.jpg");
        contents.add(content);
        content = new Content();
        content.setContentType(ContentType.IMAGE);
        content.setPath("image2.jpg");
        contents.add(content);
        product1.setContents(contents);

        ProductPriceDto priceDto1 = new ProductPriceDto();
        priceDto1.setPrice(1F);
        ProductPriceDto priceDto2 = new ProductPriceDto();
        priceDto2.setPrice(2F);

        Mockito.when(productRepository.loadDetailsById(1L)).thenReturn(Optional.of(product1));
        Mockito.when(pricesService.getPrices(1L)).thenReturn(Arrays.asList(priceDto1, priceDto2));

        Optional<ProductDetailsDto> productDetails = service.getProductDetails(1L);

        Mockito.verify(pricesService, Mockito.times(1)).getPrices(1L);

        assertEquals(true, productDetails.isPresent());
        assertEquals("product 1", productDetails.get().getProduct().getName());
        assertEquals(2, productDetails.get().getPrices().size());
        assertEquals("image1.jpg,image2.jpg", productDetails.get().getImages().stream().collect(Collectors.joining(",")));
    }
}
