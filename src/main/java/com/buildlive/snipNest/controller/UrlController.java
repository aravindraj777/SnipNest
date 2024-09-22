package com.buildlive.snipNest.controller;


import com.buildlive.snipNest.dto.UrlRequestDto;
import com.buildlive.snipNest.dto.UrlResponseDto;
import com.buildlive.snipNest.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;


    @PostMapping("/shorten-url")
    public ResponseEntity<UrlResponseDto> shortenUrl(@RequestBody UrlRequestDto data,
                                                     HttpServletRequest request){

        return ResponseEntity.ok(urlService.shortenUrl(data,request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable("id") String id){

        HttpHeaders headers = urlService.redirect(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
    }
}
