package com.buildlive.snipNest.exceptions;

import lombok.Getter;

@Getter
public class URLNotFoundException extends RuntimeException{

    private final String urlId;

    public URLNotFoundException(String urlId){

        super(String.format("Url not found",urlId));
        this.urlId = urlId;
    }


}
