package com.icc.worshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icc.worshopmongo.domain.User;
import com.icc.worshopmongo.dto.UserDTO;
import com.icc.worshopmongo.service.UserService;

@RestController //indica que é um recurso rest
@RequestMapping (value ="/users") // indica qual o  caminho do endPoint
public class UserResource {
	
		@Autowired
		private UserService service;
	
		@RequestMapping(method = RequestMethod.GET) //Indicanco que o method vai ser um endPoint rest, e define qual o metodo http vai ser utilizado para aquele endPoint
		public ResponseEntity<List<UserDTO>> findAll() {
			
			List<User> list = service.findAll();
			List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //convertendo a lista de USER em uma lista de UserDTo, atraves de uma função lambda que transforma a primeira lista em uma stream, e usando o collectors para voltar para a lista de UserDTO
			return ResponseEntity.ok().body(listDto);
			
		}
}
