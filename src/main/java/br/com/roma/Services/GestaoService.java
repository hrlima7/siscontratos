package br.com.roma.Services;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.roma.Exception.GestaoNaoEncontradoException;
import br.com.roma.Repository.GestaoRepository;
import br.com.roma.domain.Gestao;


@Service
public class GestaoService  {
	
	@Autowired
	private GestaoRepository gestaoRepository;

	
	public List<Gestao> listar () {
		return gestaoRepository.findAll();
		
	}
	
	public Gestao buscarOuFalhar(Long gestaoId) {
		return 	gestaoRepository.findById(gestaoId)
			.orElseThrow(() ->  new  GestaoNaoEncontradoException
					(gestaoId));
	}
	
	public Gestao salvar(Gestao gestao) {
		return gestaoRepository.save(gestao);
	}
	
	public Gestao alterar(Long gestaoId, Gestao gestao) {
				Gestao gestaoBanco = buscarOuFalhar(gestaoId);
		
				BeanUtils.copyProperties(gestao, gestaoBanco, "id");
				
				return salvar(gestaoBanco);
	}
	
	
	public Gestao excluir (Long gestaoId) {
		
			Gestao gestao =	buscarOuFalhar(gestaoId);
				gestaoRepository.delete(gestao);
			return gestao;
			 
			
			
		}
			
					
			
		
	}
	
