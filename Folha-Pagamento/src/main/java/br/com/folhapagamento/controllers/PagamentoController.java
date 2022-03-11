package br.com.folhapagamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.folhapagamento.config.feignclient.FeignClientConfig;
import br.com.folhapagamento.domain.dto.FuncionarioDTO;


@RestController
@RequestMapping("/v1/funcionario")
public class PagamentoController {
	
	
	@Autowired
	private FeignClientConfig feignClientConfig;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id){
		FuncionarioDTO objDTO = feignClientConfig.findById(id).getBody();
		return ResponseEntity.ok().body(objDTO);
	}

}
