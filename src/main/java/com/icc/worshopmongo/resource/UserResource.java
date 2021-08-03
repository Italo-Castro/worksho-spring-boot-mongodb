package com.icc.worshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		@RequestMapping (value ="/{id}",method = RequestMethod.GET)
		public ResponseEntity<UserDTO> findiById(@PathVariable String id) {
			User obj = service.findById(id);
			
			return ResponseEntity.ok().body(new UserDTO(obj));
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert (@RequestBody UserDTO objDto){ //requestBody para que o endpoint aceite a entrada do objeto
			User obj = service.fromDTO(objDto);
			
			obj = service.insert(obj);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //PEGANDO O ENDEREÇO DO ULTIMO OBJETO INSERIDO
			
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable String id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value ="/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
			User obj = service.fromDTO(objDto);
			
			obj.setId(id);
			obj = service.update(obj);
			
			return ResponseEntity.noContent().build();
		}
}
