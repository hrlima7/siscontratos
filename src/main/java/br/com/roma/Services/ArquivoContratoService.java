package br.com.roma.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roma.Repository.ContratoRepository;
import br.com.roma.domain.ArquivoContrato;

@Service
public class ArquivoContratoService {

	@Autowired
	ContratoRepository contratoRepository;
	
	public ArquivoContrato salvar(ArquivoContrato arquivo) {
		return contratoRepository.save(arquivo);
		
	}
	
}
