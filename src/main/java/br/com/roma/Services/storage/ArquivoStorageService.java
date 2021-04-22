package br.com.roma.Services.storage;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface ArquivoStorageService {

	void arazenar(NovoArquivo novoArquivo);
	
	default String gerarNome(String nomeOriginal) {
		return UUID.randomUUID().toString()+"_"+nomeOriginal;
	}
	
	@Getter
	@Builder
	class NovoArquivo{
		
		private String nomeArquivo;
		private InputStream inputStream;
		
	}
	
	
}
