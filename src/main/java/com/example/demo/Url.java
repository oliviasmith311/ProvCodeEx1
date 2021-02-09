package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Url {

    @Id
    @GeneratedValue
    private Long id;

    public String originalUrl;
    public int timesVisited;
    public String shortenedUrl;

    public Url(){}

    public Url(String originalUrl){
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenUrl();
    }

    public String shortenUrl(){
        Random rand = new Random();

        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;

        StringBuilder buffer = new StringBuilder(targetStringLength);
        for(int i=0; i < 10; i++){
            int randomLimitedInt = leftLimit + (int)
                    (rand.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        shortenedUrl = buffer.toString();
        return shortenedUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public int getTimesVisited() {
        return timesVisited;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
