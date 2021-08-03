package com.icc.worshopmongo.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.icc.worshopmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice //indica que essa classe ira tratar alguns erros na requisição
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardEror> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND; // retorna 404
		
		StandardEror err = new StandardEror(System.currentTimeMillis(),status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
	
	
}
