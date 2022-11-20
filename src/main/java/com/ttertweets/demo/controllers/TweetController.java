package com.ttertweets.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttertweets.demo.models.Tweet;
import com.ttertweets.demo.services.TweetService;

@RestController
@RequestMapping(value = "/api/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;
    
    @GetMapping
    public ResponseEntity<List<Tweet>> findAllTweets(){
        List<Tweet> tweets = tweetService.findAllTweets();

        if(tweets.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(tweets);
    }

    @PostMapping
    public ResponseEntity<Tweet> postTweet(@RequestBody Map<String, ?> body){

        return ResponseEntity.ok(tweetService.postTweet(body));
    }
}
