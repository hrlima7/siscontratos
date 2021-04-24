package br.com.roma.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PagamentoNaoEncontradoException extends ResponseStatusException{


	
	public PagamentoNaoEncontradoException(HttpStatus status, String menssagem) {
		super(status, menssagem);
		
	}

	public PagamentoNaoEncontradoException(String menssagem) {
		this(HttpStatus.BAD_GATEWAY, menssagem);
		
	}

	
	
	
}
	
