package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Long> {

    Url findByShortenedUrl(String shortenedUrl);

}

