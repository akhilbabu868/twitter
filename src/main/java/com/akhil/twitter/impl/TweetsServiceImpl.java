package com.akhil.twitter.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.akhil.twitter.dao.tweetsRepository;
import com.akhil.twitter.model.tweets;
import com.akhil.twitter.service.tweetsservice;



@SuppressWarnings("unused")
@Service
@Transactional
public class TweetsServiceImpl implements tweetsservice{
	
private final tweetsRepository repo;
	
    public TweetsServiceImpl(tweetsRepository repo) {
    	this.repo=repo;
    }
    
    @Override
    public tweets saveTweets(tweets tweet){
		
		return repo.save(tweet);
	}
    
    @Override
    public List <tweets> listAll(){
		
		return repo.findAll();
	}

}
