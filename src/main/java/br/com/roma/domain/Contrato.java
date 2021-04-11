package br.com.roma.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contrato {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private  String descricao;
	private  String contratante;
	private  Long  prazoInicial;

	@Column(name ="data_inicio")
	private LocalDate dataInicio;
	
	@Column(name ="data_final")
	private LocalDate dataFinal;
	
	@Column(name = "vl_global")
	private BigDecimal valorGlobal;
	
	

}
