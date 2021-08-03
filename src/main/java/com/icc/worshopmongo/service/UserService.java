package com.icc.worshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icc.worshopmongo.domain.User;
import com.icc.worshopmongo.dto.UserDTO;
import com.icc.worshopmongo.repository.UserRepository;
import com.icc.worshopmongo.service.exception.ObjectNotFoundException;				

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	 
	public List<User> findAll () {
		
		return repo.findAll();
	}
	
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}