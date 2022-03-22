package br.com.folhapagamento.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.folhapagamento.config.feignclient.FeignClientConfig;
import br.com.folhapagamento.domain.Pagamento;
import br.com.folhapagamento.domain.dto.FuncionarioDTO;
import br.com.folhapagamento.services.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService{
	
	@Autowired
	private FeignClientConfig feignClientConfig;

	@Override
	public Pagamento getPagamento(Integer idFuncionario, int diasTrabalhados) {
		FuncionarioDTO objDTO = feignClientConfig.findById(idFuncionario).getBody();
		return new Pagamento(objDTO.getNome(), objDTO.getValorDiaria(), diasTrabalhados);
	}

	
}
