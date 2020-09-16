package com.garwan.ecommece.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {


    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private List<GalleryUrlDto> galleryUrls;

    private AnimalCategoryDto animalCategory;
}
