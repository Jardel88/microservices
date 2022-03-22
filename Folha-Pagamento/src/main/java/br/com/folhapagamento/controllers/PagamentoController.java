package br.com.folhapagamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.folhapagamento.domain.Pagamento;
import br.com.folhapagamento.services.PagamentoService;


@RestController
@RequestMapping("/v1/funcionario")
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	
	
	@GetMapping(value = "/{idFuncionario}/diasTrabalhados/{diasTrabalhados}")
	public ResponseEntity<Pagamento> getPagamento(@PathVariable Integer idFuncionario, @PathVariable Integer diasTrabalhados){
		Pagamento pagamento = pagamentoService.getPagamento(idFuncionario, diasTrabalhados);
		return ResponseEntity.ok(pagamento);
	}

}
