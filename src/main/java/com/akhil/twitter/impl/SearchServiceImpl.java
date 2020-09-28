package com.akhil.twitter.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akhil.twitter.dao.SearchRepository;
import com.akhil.twitter.model.searchresult;
import com.akhil.twitter.service.SearchService;

@SuppressWarnings("unused")
@Service
@Transactional
public class SearchServiceImpl implements SearchService {

	
private final SearchRepository Searchrepo;
	
    public SearchServiceImpl(SearchRepository searchrepo) {
    	this.Searchrepo=searchrepo;
    }
	
    
    
    @Override
    public searchresult saveSearchresult(searchresult searchresult){
		
		return Searchrepo.save(searchresult);
	}
	
    
    @Override
    public List <searchresult> listAll(){
		
		return Searchrepo.findAll(Sort.by("id").descending());
	}
}
