package br.com.roma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.ArquivoContrato;

@Repository
public interface ArquivoContratoRepository extends JpaRepository<ArquivoContrato, Long> {

}
