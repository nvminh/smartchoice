package com.smartchoice.product.service.impl;

import com.smartchoice.common.dto.ProductAddDto;
import com.smartchoice.common.dto.ProductDetailsDto;
import com.smartchoice.common.dto.ProductDto;
import com.smartchoice.common.dto.SearchDto;
import com.smartchoice.common.service.PricesService;
import com.smartchoice.product.entity.Product;
import com.smartchoice.product.repository.ProductRepository;
import com.smartchoice.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final PricesService pricesService;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, PricesService pricesService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.pricesService = pricesService;
    }

    @Override
    public List<ProductDto> search(SearchDto search) {
        return productRepository.findByNameContains(search.getProductName()).stream().map(i -> modelMapper.map(i, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductAddDto product) {
        productRepository.save(modelMapper.map(product, Product.class));
    }

    @Override
    public Optional<ProductDetailsDto> getProductDetails(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.isPresent() ? Optional.of(loadProductDetails(product.get())) : Optional.empty();
    }

    private ProductDetailsDto loadProductDetails(Product product) {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setProduct(modelMapper.map(product, ProductDto.class));
        productDetailsDto.setPrices(pricesService.getPrices(product.getId()));
        productDetailsDto.setImages(product.getImages());
        return productDetailsDto;
    }
}
