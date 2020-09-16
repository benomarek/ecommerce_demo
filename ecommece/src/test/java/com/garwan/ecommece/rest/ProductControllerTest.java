package com.garwan.ecommece.rest;

import com.garwan.ecommece.model.entity.dto.AnimalCategoryDto;
import com.garwan.ecommece.model.entity.dto.GalleryUrlDto;
import com.garwan.ecommece.model.entity.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ProductControllerTest extends AbstractControllerTest {

    @Test
    public void shouldReturnProduct() throws Exception {
        List<ProductDto> products = new ArrayList<>();
        List<GalleryUrlDto> urls = new ArrayList<>();

        urls.add(new GalleryUrlDto(1L, "www.fotky.xyz/fotokrmiva.jpg"));
        urls.add(new GalleryUrlDto(2L, "www.fotky.xyz/fotokrmiva2.jpg"));
        products.add(new ProductDto(1L, "Krmivo pre macicky", new BigDecimal(50), "desc", urls, new AnimalCategoryDto("cat")));

        when(productService.getProduct(1L)).thenReturn(products.get(0));

        mockMvc.perform(get("/products/1").accept(MediaType.APPLICATION_JSON).header("Page-Size", 5))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("price", is(50)))
                .andExpect(jsonPath("description", is("desc")));

    }
}

