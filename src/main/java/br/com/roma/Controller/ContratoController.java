package br.com.roma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roma.Services.ContratoService;
import br.com.roma.domain.Contrato;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
	
	@Autowired
	ContratoService contratoService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		
		
		List<Contrato> contratos =  contratoService.listar();
		return ResponseEntity.ok(contratos);
		
	}
	
	@GetMapping("/{contratoId}")
	public Contrato buscar(@PathVariable Long contratoId) {
				return contratoService.buscarOuFalhar(contratoId);
	
	}
	
	@PostMapping
	public ResponseEntity<Contrato> salvar(@RequestBody Contrato contrato){
		return ResponseEntity.ok(contratoService.salvar(contrato));
		
		
	}
	
	

}
