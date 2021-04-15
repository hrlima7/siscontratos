package br.com.roma.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.roma.Exception.GestaoNaoEncontradoException;
import br.com.roma.Exception.Problema;
import br.com.roma.Services.GestaoService;
import br.com.roma.domain.Gestao;

@RestController
@RequestMapping("/gestao")
public class GestaoController {

	@Autowired
	GestaoService gestaoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Gestao> listar(){
		return gestaoService.listar();
		
	}
	
	@GetMapping("/{gestaoId}")
	@ResponseStatus(HttpStatus.OK)
	public Gestao buscar(@PathVariable Long gestaoId) {
		return gestaoService.buscarOuFalhar(gestaoId);
		
	}
	
	@PostMapping
	public Gestao salvar(@RequestBody  Gestao gestao) {
		return gestaoService.salvar(gestao);
	}
	
	@PutMapping("/{gestaoId}")
	public Gestao atualizar(@PathVariable Long gestaoId,
				@RequestBody Gestao gestao) {
		
		return gestaoService.alterar(gestaoId, gestao);
	}
	
	@DeleteMapping("/{gestaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long gestaoId){			
		gestaoService.excluir(gestaoId);	
	}
	
	@ExceptionHandler(GestaoNaoEncontradoException.class)
	public ResponseEntity<?> tratarEntidadeNaoEncontradaException(
			GestaoNaoEncontradoException e){
		
		Problema problema = Problema.builder()
				.dataHora(LocalDateTime.now())
				.mensagem(e.getMessage()).build();
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problema);
		
		
	}
	
	
	
		//@DeleteMapping("/{gestaoId}")
		//@ResponseStatus(HttpStatus.NO_CONTENT)
		//public void excluir(@PathVariable Long gestaoId){		
		//	try {
		//	gestaoService.excluir(gestaoId);
		//}catch (GestaoNaoEncontradoException e) {
		//	throw new  GestaoNaoEncontradoException(HttpStatus.NOT_FOUND,
		//		String.format("Usuario gestor de Id  %d nao localizado",gestaoId));
		//}
		
		
	
	
	
}
