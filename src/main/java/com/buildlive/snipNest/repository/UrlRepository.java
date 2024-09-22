package com.buildlive.snipNest.repository;

import com.buildlive.snipNest.entities.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntity,String> {
}
