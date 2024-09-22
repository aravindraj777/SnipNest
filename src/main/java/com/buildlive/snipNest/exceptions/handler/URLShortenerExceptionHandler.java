package com.buildlive.snipNest.exceptions.handler;

import com.buildlive.snipNest.exceptions.URLNotFoundException;
import com.buildlive.snipNest.exceptions.model.URLShortenerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class URLShortenerExceptionHandler {

    public ResponseEntity<URLShortenerError> handleUrlNotFound(URLNotFoundException ex){
        URLShortenerError errorResponse = URLShortenerError.builder()
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(List.of(ex.getMessage()))
                .build();

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
