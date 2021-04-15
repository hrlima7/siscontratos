package br.com.roma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArquivoContrato {
	
		@EqualsAndHashCode.Include
		@Id
		@Column(name = "contrato_id")
		private Long id;
		
		@OneToOne
		@MapsId
		private Contrato contrato;
	//	private MultipartFile arquivoPDF;
		private String nome_arquivo;
		private String descricao;
		private String content_type ;
		private Long tamanho;
	
	
}
