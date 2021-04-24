package br.com.roma.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	@Column(name = "num_processo")
	private String numProcesso;
	
	@Column(name ="mes_referencia" )
	private String mesReferencia;
	
	@Column(name = "dt_pagamento")
	private LocalDate dataPagamento;
	
	private BigDecimal valor;
	
	@Column(name ="num_parcela")
	private String numParcela;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_contrato")
	private Contrato idContrato;
	
}
