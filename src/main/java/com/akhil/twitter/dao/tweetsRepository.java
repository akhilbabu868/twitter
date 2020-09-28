package com.akhil.twitter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.twitter.model.tweets;



public interface tweetsRepository extends JpaRepository<tweets, String> {

}
