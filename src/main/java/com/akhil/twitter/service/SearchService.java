package com.akhil.twitter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhil.twitter.model.searchresult;
import com.akhil.twitter.model.tweets;

@SuppressWarnings("unused")
@Service
public interface SearchService {

	searchresult saveSearchresult(searchresult result);
	
	List<searchresult> listAll();
	
}
