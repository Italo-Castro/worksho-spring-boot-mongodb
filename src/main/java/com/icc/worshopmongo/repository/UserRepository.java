package com.icc.worshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.icc.worshopmongo.domain.User;

@Repository //indicando que e o repositorio, extendendo MongoRepository que tem por paramentro o tipo da classe e do ID
public interface UserRepository extends MongoRepository<User, String>{
	
	
	
}
