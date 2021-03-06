package com.akhil.twitter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.Ascii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.akhil.twitter.model.searchresult;
import com.akhil.twitter.model.tweets;
import com.akhil.twitter.service.SearchService;
import com.akhil.twitter.service.tweetsservice;

@RestController
public class TwitterController {

	@Autowired
	private Twitter twitter;

	@Autowired
	private tweetsservice service;

	@Autowired
	private SearchService searchservice;

	public TwitterController(Twitter twitter, tweetsservice service, SearchService seachservice) {
		this.twitter = twitter;
		this.service = service;
		this.searchservice = searchservice;
	}

	
	// function return index page
	
	@GetMapping("/")
	public ModelAndView mv() {

		ModelAndView mv = new ModelAndView("index");
		return mv;

	}
	
	
	
	
	// function returns Search Result by  followers and #hashtag 

	@PostMapping("/tweets")
	public List<searchresult> nameList(@RequestParam("keyword") String keyword, HttpSession session) {

		SearchParameters params = new SearchParameters(keyword);
		SearchResults results = twitter.searchOperations().search(params);

		List<Tweet> Searchresult = results.getTweets();
			for (Tweet tweet : Searchresult) {

			searchresult objResult = new searchresult(0, tweet.getText(), tweet.getProfileImageUrl(),tweet.getFromUser());
			searchservice.saveSearchresult(objResult);
		}

		List<searchresult> searchlist = searchservice.listAll();
		return searchlist;
	}

	
	//function which returns followers tweets
	@PostMapping("/timeline")
	public List<tweets> timelineList() {

		List<Tweet> timeline = twitter.timelineOperations().getHomeTimeline();
		for (Tweet tweet : timeline) {
			tweets objTweets = new tweets(0, tweet.getText(), tweet.getProfileImageUrl(), tweet.getFromUser());
			service.saveTweets(objTweets);
		}
		List<tweets> home = service.listAll();
		return home;
	}


}
