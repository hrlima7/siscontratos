package br.com.roma.Services;

import java.io.InputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.roma.Repository.ArquivoContratoRepository;
import br.com.roma.Repository.ContratoRepository;
import br.com.roma.Services.storage.ArquivoStorageService;
import br.com.roma.Services.storage.ArquivoStorageService.NovoArquivo;
import br.com.roma.domain.ArquivoContrato;

@Service
public class ArquivoContratoService {

	@Autowired
	ContratoRepository contratoRepository;
	
	@Autowired
	ArquivoContratoRepository arquivoRepository;
	
	@Autowired
	ArquivoStorageService arquivoStorageService;
	
	@Transactional
	public ArquivoContrato salvar(ArquivoContrato arquivo, InputStream dadosArquivo) {
		
		String nomeArquivo = arquivoStorageService.gerarNome(arquivo.getNome_arquivo());
		
		Long contratoId = arquivo.getContrato().getId();
		Optional<ArquivoContrato> arqcontratoExistente = contratoRepository.findContratoById(contratoId);

		
		
				if(arqcontratoExistente.isPresent()) {
						arquivoRepository.delete(arqcontratoExistente.get());
					}	
				
				arquivo =  contratoRepository.save(arquivo);
				contratoRepository.flush();
				
				NovoArquivo novoArquivo   =  NovoArquivo.builder()
											.nomeArquivo(nomeArquivo)
											.inputStream(dadosArquivo).build();
				
				arquivoStorageService.arazenar(novoArquivo);
				
			return arquivo;
		
	}
	
}
