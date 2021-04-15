package br.com.roma.domain.input;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class InputArquivoPDF {

	
	private MultipartFile arquivo;
	private String descricao;
	
	
}
