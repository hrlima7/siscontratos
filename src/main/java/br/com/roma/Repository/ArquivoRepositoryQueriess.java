package br.com.roma.Repository;

import org.springframework.stereotype.Repository;

import br.com.roma.domain.ArquivoContrato;

@Repository
public interface ArquivoRepositoryQueriess {
	
		ArquivoContrato save(ArquivoContrato arquivo);

}
