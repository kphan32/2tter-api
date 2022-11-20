package com.ttertweets.demo.services;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttertweets.demo.models.Tweet;
import com.ttertweets.demo.repositories.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    public Tweet findById(int id){
        Optional<Tweet> tOptional = tweetRepository.findById(id);
        if(!tOptional.isPresent()){
            return null;
        }
        return tOptional.get();
    }

    public List<Tweet> findAllTweets(){
        return tweetRepository.findAll();
    }

    public Tweet postTweet(Map<String,?> body){
        Tweet newTweet = new Tweet();
        newTweet.setHandle((String)body.get("handle"));
        newTweet.setUsername((String)body.get("username"));
        newTweet.setBody((String)body.get("body"));
        newTweet.setCreatedAt(Timestamp.from(Instant.now()));

        return tweetRepository.save(newTweet);
    }
}
