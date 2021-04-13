package br.com.roma.Exception.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.roma.Exception.GestaoNaoEncontradoException;
import br.com.roma.Exception.Problema;

@ControllerAdvice
public class ApiExceptionHandler extends  ResponseEntityExceptionHandler {


	@ExceptionHandler(GestaoNaoEncontradoException.class)
	public ResponseEntity<?> tratarEntidadeNaoEncontradaException(
			GestaoNaoEncontradoException e){
		
		Problema problema = Problema.builder()
				.dataHora(LocalDateTime.now())
				.mensagem(e.getMessage()).build();
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problema);
				

		@Override
		protected ResponseEntity<Object> handleExceptionInternal(
				Exception ex, @Nullable Object body, HttpHeaders headers, 
				HttpStatus status, WebRequest request) {

					body = Problema.builder()
					.dataHora(LocalDateTime.now())
					.mensagem(status.getReasonPhrase()).build();
			
			return super.handleExceptionInternal(ex, body, headers, status, request)
		
	}
	
	
}
