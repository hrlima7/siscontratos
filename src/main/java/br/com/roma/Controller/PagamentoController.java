package br.com.roma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roma.Services.PagamentoService;
import br.com.roma.domain.Pagamento;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	@Autowired
	PagamentoService pagamentoService;
	
	@GetMapping
	public List<Pagamento> buscar(){
		return pagamentoService.buscar();
	}
	
	@GetMapping("/{pagamentoId}")
	public Pagamento buscar(@PathVariable Long pagamentoId ) {
		return pagamentoService.buscarOuFalhar(pagamentoId);
	}
	
	
	@PostMapping
	public Pagamento salvar(@RequestBody Pagamento pagamento) {
		return pagamentoService.salvar(pagamento);
		
	}
	
	
	
}
