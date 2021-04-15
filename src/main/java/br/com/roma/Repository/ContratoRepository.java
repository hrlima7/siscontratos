package br.com.roma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>, ArquivoRepositoryQueriess {

	
	
}
