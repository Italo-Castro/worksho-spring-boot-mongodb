package com.icc.worshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.icc.worshopmongo.domain.User;



@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
