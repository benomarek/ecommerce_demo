package com.garwan.ecommece.controller.exception;

import com.garwan.ecommece.exceptions.DataNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ProductExceptionAdvice {

    @ExceptionHandler({DataNotFound.class})
    public ResponseEntity<String> handleNotFoundProduct(DataNotFound e) {
        return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
    }

}
