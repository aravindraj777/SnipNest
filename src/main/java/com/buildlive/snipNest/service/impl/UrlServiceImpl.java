package com.buildlive.snipNest.service.impl;

import com.buildlive.snipNest.dto.UrlRequestDto;
import com.buildlive.snipNest.dto.UrlResponseDto;
import com.buildlive.snipNest.entities.UrlEntity;
import com.buildlive.snipNest.exceptions.URLNotFoundException;
import com.buildlive.snipNest.repository.UrlRepository;
import com.buildlive.snipNest.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    @Override
    public UrlResponseDto shortenUrl(UrlRequestDto data, HttpServletRequest request) {

        String id;

        do {
            id = RandomStringUtils.randomAlphanumeric(5,10);
        }
        while (urlRepository.existsById(id));
        urlRepository.save(new UrlEntity(
                id,
                data.url(),
                LocalDateTime.now().plusMinutes(1)
        ));

        String redirectUrl = request.getRequestURL().toString().replace("shorten-url",id);

        return new UrlResponseDto(data.url(),redirectUrl);
    }

    @Override
    public HttpHeaders redirect(String id) {

        UrlEntity url = urlRepository.findById(id)
                .orElseThrow(()->new URLNotFoundException(id));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getUrl()));
        return headers;
    }
}
