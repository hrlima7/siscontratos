package br.com.roma.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class GestaoNaoEncontradoException extends ResponseStatusException{

	private static final long serialVersionUID = 1L;

	public GestaoNaoEncontradoException(HttpStatus status, String menssagem) {
		super(status, menssagem);
		
	}

	public GestaoNaoEncontradoException(Long gestaoId) {
		this(HttpStatus.NOT_FOUND, String.format("Usuario Gestao de Id %d nao localizado !!!",gestaoId));
		
	}
	

	
	
	
}
	
