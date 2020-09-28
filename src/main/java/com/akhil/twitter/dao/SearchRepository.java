package com.akhil.twitter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.twitter.model.searchresult;

public interface SearchRepository extends JpaRepository<searchresult, Integer>  {

}
