package br.com.roma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.roma.Services.ArquivoContratoService;
import br.com.roma.Services.ContratoService;
import br.com.roma.domain.ArquivoContrato;
import br.com.roma.domain.Contrato;
import br.com.roma.domain.input.InputArquivoPDF;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
	
	@Autowired
	ContratoService contratoService;
	
	@Autowired
	ArquivoContratoService arquivoContratoService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		
		
		List<Contrato> contratos =  contratoService.listar();
		return ResponseEntity.ok(contratos);
		
	}
	
	@GetMapping("/{contratoId}")
	public Contrato buscar(@PathVariable Long contratoId) {
				return contratoService.buscarOuFalhar(contratoId);
	
	}
	
	@PostMapping
	public ResponseEntity<Contrato> salvar(@RequestBody Contrato contrato){
		return ResponseEntity.ok(contratoService.salvar(contrato));
		
		
	}
	
	@PutMapping(path ="/{contratoId}/arquivo",consumes  = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ArquivoContrato inserirContrato(@PathVariable Long contratoId,
			InputArquivoPDF arquivo ) {
		
		
		System.out.println("O ID  do contrato enviado é:"+ contratoId);
		Contrato contrato  = buscar(contratoId);
			
		System.out.println(contrato.toString());;
		System.out.println("o que contem em arquivo é: "+ arquivo.toString());;
		
	
		
		ArquivoContrato arquivoContrato =  new ArquivoContrato();

				arquivoContrato.setContrato(contrato);
				
		
				
				arquivoContrato.setDescricao(arquivo.getDescricao());
				arquivoContrato.setContent_type(arquivo.getArquivo().getContentType());
				arquivoContrato.setTamanho(arquivo.getArquivo().getSize());
				
				System.out.println(arquivoContrato.toString());
				arquivoContrato.setNome_arquivo(arquivo.getArquivo().getOriginalFilename());
				
				System.out.println(arquivoContrato.toString());
				
			ArquivoContrato arq = arquivoContratoService.salvar(arquivoContrato); 	
				return arq;
	}
	
	

}
