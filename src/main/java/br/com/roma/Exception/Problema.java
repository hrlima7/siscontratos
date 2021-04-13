package br.com.roma.Exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Problema {

	
	private LocalDateTime dataHora;
	private String mensagem;
	private String status;
}
