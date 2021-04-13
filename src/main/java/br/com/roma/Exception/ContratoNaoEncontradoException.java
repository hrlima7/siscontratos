package br.com.roma.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ContratoNaoEncontradoException extends ResponseStatusException{


	
	public ContratoNaoEncontradoException(HttpStatus status, String menssagem) {
		super(status, menssagem);
		
	}

	public ContratoNaoEncontradoException(String menssagem) {
		this(HttpStatus.BAD_GATEWAY, menssagem);
		
	}

	
	
	
}
	
