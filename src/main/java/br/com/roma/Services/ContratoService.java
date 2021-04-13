package br.com.roma.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.roma.Exception.ContratoNaoEncontradoException;
import br.com.roma.Repository.ContratoRepository;
import br.com.roma.domain.Contrato;

@Service
public class ContratoService implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	@Autowired
	ContratoRepository contratoRespository;
	
	public List<Contrato> listar(){
		return contratoRespository.findAll();
	}
	
	public Contrato buscarOuFalhar(Long id) {
		
	return  contratoRespository.findById(id)
				.orElseThrow(() -> new ContratoNaoEncontradoException(HttpStatus.NOT_FOUND,
						"CONTRATO NAO ENCONTRADO !!!"));
	
	}

	@Transactional
	public Contrato salvar(Contrato contrato) {
		return contratoRespository.save(contrato);
	
	}
	
	
	
	
}

	

