package com.ttertweets.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ttertweets.demo.models.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{
    
}
