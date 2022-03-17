package br.com.folhapagamento.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	
	private String nome;
	private double valorDiaria;
	private Integer diasTrabalhados;
	
	public double getTotal() {
		return diasTrabalhados * valorDiaria;
	}

}
