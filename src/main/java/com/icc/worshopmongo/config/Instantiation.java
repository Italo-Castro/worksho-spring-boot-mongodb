package com.icc.worshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.icc.worshopmongo.domain.User;
import com.icc.worshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null,"Maria Brwon","mariag@gmail.com");
        User alex = new User(null,"Alex Green","alex@gmail.com");
        User bob =  new User(null,"Bob Grey","bob@gmail.com");
        
        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);
	}

	
	
}
