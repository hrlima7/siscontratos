package br.com.roma.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roma.Exception.PagamentoNaoEncontradoException;
import br.com.roma.Repository.PagamentoRepository;
import br.com.roma.domain.Pagamento;

@Service
public class PagamentoService {
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	
	public List<Pagamento> buscar(){
		return pagamentoRepository.findAll();
		
	}
	
	public Pagamento buscarOuFalhar(Long pagamentoId) {
				return pagamentoRepository.findById(pagamentoId).orElseThrow(
						() -> new PagamentoNaoEncontradoException("Pagamento Nao localizado !!"));
	}

	public Pagamento salvar(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}
	
}
