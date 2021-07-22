package com.icc.worshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icc.worshopmongo.domain.User;
import com.icc.worshopmongo.service.UserService;

@RestController //indica que é um recurso rest
@RequestMapping (value ="/users") // indica qual o  caminho do endPoint
public class UserResource {
	
		@Autowired
		private UserService service;
	
		@RequestMapping(method = RequestMethod.GET) //Indicanco que o method vai ser um endPoint rest, e define qual o metodo http vai ser utilizado para aquele endPoint
		public ResponseEntity<List<User>> findAll() {
			
			List<User> list = service.findAll();
			return ResponseEntity.ok().body(list);
			
		}
}
