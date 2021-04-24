package br.com.roma.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contrato {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
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
	
	@ManyToOne
	@JoinColumn(name="idgestao")
	@NotNull
	private Gestao gestao;
	
	@Column(name="ativo")
	private boolean ativo = true;
		
	@OneToMany(mappedBy= "idContrato")
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	
	
	public void ativar() {
	setAtivo(true);
	}
	
	public void desativar() {
	setAtivo(false);
	}

	
	public Boolean cadastrarPagamento(Pagamento pagamento) {
		return  getPagamentos().contains(pagamento);
		
	}
	
	
}
