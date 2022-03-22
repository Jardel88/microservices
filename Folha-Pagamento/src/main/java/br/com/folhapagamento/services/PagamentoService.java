package br.com.folhapagamento.services;


import br.com.folhapagamento.domain.Pagamento;


public interface PagamentoService {
	
	public Pagamento getPagamento(Integer idFuncionario, int diasTrabalhados);
}
