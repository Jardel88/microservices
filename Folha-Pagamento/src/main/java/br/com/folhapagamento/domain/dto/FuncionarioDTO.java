package br.com.folhapagamento.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
	
	private Integer id;
	private String nome;
	private String cpf;
	private double valorDiaria;

}
