package br.com.funcionario.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.funcionario.domain.dto.FuncionarioDTO;
import br.com.funcionario.services.FuncionarioService;


@RestController
@RequestMapping("v1/funcionario")
public class FuncionarioController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.map(funcionarioService.findById(id), FuncionarioDTO.class));
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> findAll(){
		return ResponseEntity.ok().body(funcionarioService.findAll()
				.stream().map(x -> mapper.map(x, FuncionarioDTO.class)).collect(Collectors.toList()));
	}

}
