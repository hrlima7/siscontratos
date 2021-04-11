package br.com.roma.Exception;

public class ContratoNaoEncontradoException extends RuntimeException{

	public ContratoNaoEncontradoException(String message){
		super("Contrato Não localizado ");
	}
	
	public ContratoNaoEncontradoException(Long contratoId){
		this(String.format("Não existe um cadastro de Contrato com código !!!!!! %d", contratoId));
	}
	
}
	
