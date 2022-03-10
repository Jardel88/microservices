package br.com.folhapagamento.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {
	
	private Integer id;
	private String name;
	private String cpf;
	private double valorDiaria;
	private Integer diasTrabalhados;
	

}
