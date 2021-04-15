package br.com.roma.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.roma.Repository.ArquivoRepositoryQueriess;
import br.com.roma.domain.ArquivoContrato;

@Repository
public class ArquivoContratoRepositoryImpl implements ArquivoRepositoryQueriess {

	@PersistenceContext
	EntityManager manager;

	@Transactional
	@Override
	public ArquivoContrato save(ArquivoContrato arquivo) {
		
		return manager.merge(arquivo);
	}
}
