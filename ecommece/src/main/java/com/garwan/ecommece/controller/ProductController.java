package com.garwan.ecommece.controller;

import com.garwan.ecommece.controller.utils.PagingHeaders;
import com.garwan.ecommece.controller.utils.PagingResponse;
import com.garwan.ecommece.exceptions.DataNotFound;
import com.garwan.ecommece.model.entity.Product;
import com.garwan.ecommece.model.entity.dto.ProductDto;
import com.garwan.ecommece.service.ProductService;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProduct(@PathVariable Long id) throws DataNotFound {

        return productService.getProduct(id);


    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductDto>> getProducts(@And({
            @Spec(path = "price", params = {"min, max"}, spec = Between.class),
            @Spec(path = "name", params = "name", spec = Like.class),
    }) Specification<Product> spec,
                                        Sort sort,
                                        @RequestHeader HttpHeaders headers) {

        final PagingResponse response = productService.getProducts(spec,headers,sort);
        return new ResponseEntity<>(response.getElements(), returnHttpHeaders(response), HttpStatus.OK);

    }


    public HttpHeaders returnHttpHeaders(PagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }


}
