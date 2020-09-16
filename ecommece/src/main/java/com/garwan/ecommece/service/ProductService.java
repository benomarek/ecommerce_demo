package com.garwan.ecommece.service;

import com.garwan.ecommece.controller.utils.PagingHeaders;
import com.garwan.ecommece.controller.utils.PagingResponse;
import com.garwan.ecommece.exceptions.DataNotFound;
import com.garwan.ecommece.model.entity.AnimalCategory;
import com.garwan.ecommece.model.entity.GalleryUrl;
import com.garwan.ecommece.model.entity.Product;
import com.garwan.ecommece.model.entity.dto.AnimalCategoryDto;
import com.garwan.ecommece.model.entity.dto.GalleryUrlDto;
import com.garwan.ecommece.model.entity.dto.ProductDto;
import com.garwan.ecommece.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto getProduct(Long id) throws DataNotFound {
        return productRepository.findById(id)
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(),
                        product.getGallery()
                                .stream().map(g -> new GalleryUrlDto(g.getId(), g.getUrl())).collect(Collectors.toList()), new AnimalCategoryDto("cat")))
                .orElseThrow(() -> new DataNotFound("Product with id=" + id + " not found"));

    }

    public List<ProductDto> getProducts() throws DataNotFound {
        return StreamSupport.stream(productRepository.findAll().spliterator(),false)
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(),
                        product.getGallery()
                                .stream().map(g -> new GalleryUrlDto(g.getId(), g.getUrl())).collect(Collectors.toList()), new AnimalCategoryDto("cat")))
                .collect(Collectors.toList());
    }


    public PagingResponse getProducts(Specification<Product> spec, HttpHeaders headers, Sort sort) {
        if (isRequestPaged(headers)) {
            return getProducts(spec, buildPageRequest(headers, sort));
        } else {
            List<ProductDto> entities = getProducts(spec, sort);
            return new PagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities);
        }
    }

    private PagingResponse getProducts(Specification<Product> spec, Pageable buildPageRequest) {
        List<ProductDto> list = productRepository.findAll(spec, buildPageRequest).stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getGallery()
                        .stream()
                        .map(g -> new GalleryUrlDto(g.getId(), g.getUrl()))
                        .collect(Collectors.toList()), new AnimalCategoryDto("cat")))
                .collect(Collectors.toList());

        Page<ProductDto> page = new PageImpl<>(list, buildPageRequest, list.size());

        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), buildPageRequest.getOffset(), (long) page.getTotalPages(), page.getContent());
    }

    private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }

    public List<ProductDto> getProducts(Specification<Product> spec, Sort sort) {
        return productRepository.findAll(spec, sort).stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getGallery()
                        .stream().map(g -> new GalleryUrlDto(g.getId(), g.getUrl())).collect(Collectors.toList()), new AnimalCategoryDto("cat")))
                .collect(Collectors.toList());
    }

    private boolean isRequestPaged(HttpHeaders headers) {
        return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
    }

    public void saveProduct(ProductDto p) {
        Product product = new Product(p.getId(), p.getName(), p.getPrice(), p.getDescription(), p.getGalleryUrls()
                .stream().map(g -> new GalleryUrl(g.getId(), g.getName())).collect(Collectors.toList()), new AnimalCategory(p.getAnimalCategory().getName()));
        product.getGallery().get(0).setProduct(product);
        productRepository.save(product);
    }
}
