package com.garwan.ecommece.service;

import com.garwan.ecommece.exceptions.DataNotFound;
import com.garwan.ecommece.model.entity.dto.AnimalCategoryDto;
import com.garwan.ecommece.model.entity.dto.GalleryUrlDto;
import com.garwan.ecommece.model.entity.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {



    @Autowired
    ProductService productService;

    @Test
    public void shouldReturProductDto() throws DataNotFound {

        productService.saveProduct(new ProductDto(1L, "krmivo", new BigDecimal(55.00).setScale(2, RoundingMode.CEILING), "popis", new ArrayList<>() {
            {
                add(new GalleryUrlDto(1L, "sdadsd.com/sdasd.jpg"));
            }
        },new AnimalCategoryDto("cats")));
        ProductDto productDto = productService.getProduct(1L);

        assertEquals(Long.valueOf(1),productDto.getId());
        assertEquals("krmivo",productDto.getName());
        assertEquals(new BigDecimal(55.00).setScale(2, RoundingMode.CEILING),productDto.getPrice());
        assertEquals("popis",productDto.getDescription());
    }

    @Test
    public void shouldReturProductDtoList() throws DataNotFound {

        productService.saveProduct(new ProductDto(1L, "krmivo", new BigDecimal(55.00), "popis", new ArrayList<>() {
            {
                add(new GalleryUrlDto(1L, "sdadsd.com/sdasd.jpg"));
            }
        },new AnimalCategoryDto("cats")));
        productService.saveProduct(new ProductDto(2L, "krmivo", new BigDecimal(55.00), "popis", new ArrayList<>() {
            {
                add(new GalleryUrlDto(1L, "sdadsd.com/sdasd.jpg"));
            }
        },new AnimalCategoryDto("cats")));
        productService.saveProduct(new ProductDto(3L, "krmivo", new BigDecimal(55.00), "popis", new ArrayList<>() {
            {
                add(new GalleryUrlDto(1L, "sdadsd.com/sdasd.jpg"));
            }
        },new AnimalCategoryDto("cats")));
        List<ProductDto> products = productService.getProducts();

        assertThat(products.size(), greaterThan(2));

    }
}
