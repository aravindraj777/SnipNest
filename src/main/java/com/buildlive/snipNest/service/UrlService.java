package com.buildlive.snipNest.service;

import com.buildlive.snipNest.dto.UrlRequestDto;
import com.buildlive.snipNest.dto.UrlResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;


public interface UrlService {

    UrlResponseDto shortenUrl(UrlRequestDto data, HttpServletRequest request);

    HttpHeaders redirect(String id);
}
