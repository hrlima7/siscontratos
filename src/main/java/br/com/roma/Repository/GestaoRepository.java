package br.com.roma.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.Gestao;

@Repository
public interface GestaoRepository extends JpaRepository<Gestao, Long> {
	
	
}
