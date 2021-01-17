package com.smartchoice.prices.service.impl;

import com.smartchoice.common.dto.ProductPriceDto;
import com.smartchoice.prices.service.PriceCollector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PricesServiceImplTest {

    @Test
    void getPrices() {
        ProductPriceDto dto1 = new ProductPriceDto();
        dto1.setPrice(1);
        ProductPriceDto dto2 = new ProductPriceDto();
        dto2.setPrice(2);

        PriceCollector collector1 = Mockito.mock(PriceCollector.class);
        PriceCollector collector2 = Mockito.mock(PriceCollector.class);
        Mockito.when(collector1.getPrice(1L)).thenReturn(dto1);
        Mockito.when(collector2.getPrice(1L)).thenReturn(dto2);

        PricesServiceImpl service = new PricesServiceImpl(Arrays.asList(collector1, collector2));
        List<ProductPriceDto> dtos = service.getPrices(1L);

        Mockito.verify(collector1, Mockito.times(1)).getPrice(1L);
        Mockito.verify(collector2, Mockito.times(1)).getPrice(1L);

        assertEquals(2, dtos.size());
        assertEquals(1, dtos.get(0).getPrice());
        assertEquals(2, dtos.get(1).getPrice());
    }
}
