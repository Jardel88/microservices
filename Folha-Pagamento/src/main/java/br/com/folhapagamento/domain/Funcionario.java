package br.com.folhapagamento.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
	
	private Integer id;
	private String name;
	private String cpf;
	private double valorDiaria;

}
