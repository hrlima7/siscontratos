package br.com.roma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {

	
	
}
