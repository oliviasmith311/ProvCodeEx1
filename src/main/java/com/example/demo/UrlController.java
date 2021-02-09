package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlController {

    private UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    @PostMapping("/")
    public String shortenUrl(String originalUrl){
        Url urlToShorten = new Url(originalUrl);
        urlRepository.save(urlToShorten);
        return urlToShorten.getShortenedUrl();
    }

    @GetMapping
    public String getOriginalUrl(@PathVariable String urlShortCode){
        Url urlToReturn = urlRepository.findByShortenedUrl(urlShortCode);
        String originalUrl = urlToReturn.getOriginalUrl();
        return originalUrl;
    }
}
