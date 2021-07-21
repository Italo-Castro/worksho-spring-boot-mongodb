package com.icc.worshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icc.worshopmongo.domain.User;

@RestController //indica que é um recurso rest
@RequestMapping (value ="/users") // indica qual o  caminho do endPoint
public class UserResource {
	
	
		@RequestMapping(method = RequestMethod.GET) //Indicanco que o method vai ser um endPoint rest, e define qual o metodo http vai ser utilizado para aquele endPoint
		public ResponseEntity<List<User>> findAll() {
			User maria = new User("1","Maria Brown","maria@gmail.com");
			User alex = new User("2","Alex Green","alex@gmail.com");
			
			List<User> list = new ArrayList<>();
			list.addAll(Arrays.asList(maria,alex));
			
			return ResponseEntity.ok().body(list);
			
		}
	
}
