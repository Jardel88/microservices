package br.com.folhapagamento.config.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.folhapagamento.domain.dto.FuncionarioDTO;


@Component
@FeignClient(name = "pagamento", url = "localhost:8080/v1", path = "/funcionario")
public interface FeignClientConfig {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id);

}
