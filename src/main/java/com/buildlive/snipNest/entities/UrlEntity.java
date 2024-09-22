package com.buildlive.snipNest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrlEntity {

    private String id;
    private String url;

    @Indexed(expireAfterSeconds = 90)
    private LocalDateTime expiresAt;


}
