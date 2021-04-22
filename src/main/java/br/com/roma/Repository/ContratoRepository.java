package br.com.roma.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.ArquivoContrato;
import br.com.roma.domain.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>, ArquivoContratoRepositoryQueries {

	
	@Query(" select a from ArquivoContrato a where a.contrato.id = :contratoId")
	Optional<ArquivoContrato> findContratoById(@Param("contratoId")Long contratoId);
	
	@Modifying
	@Query("delete from ArquivoContrato a where a.contrato.id =:contrato")
	void deleteContrato(@Param("contrato") Long contrato);
	
}
