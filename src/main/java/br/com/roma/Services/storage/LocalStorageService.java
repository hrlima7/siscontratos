package br.com.roma.Services.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import br.com.roma.Exception.storage.StorageException;

@Service
public class LocalStorageService implements ArquivoStorageService {

	@Override
	public void arazenar(NovoArquivo novoArquivo) {
	
		try {
			Path arquivoPath =  Paths.get("/tmp/ARQUIVO", novoArquivo.getNomeArquivo());
			FileCopyUtils.copy(novoArquivo.getInputStream(),Files.newOutputStream(arquivoPath));
		
		} catch (IOException e) {
			throw  new StorageException ("Nao foi possivel armazenar os dados",e.getCause());
		}
	}

	
}
