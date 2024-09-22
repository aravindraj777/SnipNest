package com.buildlive.snipNest.exceptions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record URLShortenerError(

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime timeStamp,
        Integer code,
        String status,
        List<String> errors
) {
}
