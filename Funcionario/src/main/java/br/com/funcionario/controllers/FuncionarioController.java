package br.com.funcionario.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.funcionario.domain.dto.FuncionarioDTO;
import br.com.funcionario.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("v1/funcionario")
public class FuncionarioController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping(value = "/{id}")
	@Operation(
			tags = {"Funcionario"},
			responses = {@ApiResponse(responseCode = "200", description = "success"),
					@ApiResponse(responseCode = "404", description = "Not found")}
		)
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.map(funcionarioService.findById(id), FuncionarioDTO.class));
	}
	
	@GetMapping
	@Operation(
			tags = {"Funcionario"},
			responses = {@ApiResponse(responseCode = "200", description = "success")}
		)
	public ResponseEntity<List<FuncionarioDTO>> findAll(){
		return ResponseEntity.ok().body(funcionarioService.findAll()
				.stream().map(x -> mapper.map(x, FuncionarioDTO.class)).collect(Collectors.toList()));
	}
	
	@PostMapping
	@Operation(
			tags = {"Funcionario"},
			responses = {@ApiResponse(responseCode = "201", description = "Created success")}
		)
	public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO objDTO){
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(funcionarioService.create(objDTO).getId()).toUri();
		return ResponseEntity.created(uri).body(objDTO);
	}
	
	@PutMapping(value = "/{id}")
	@Operation(
			tags = {"Funcionario"},
			responses = {@ApiResponse(responseCode = "200", description = "Update success"),
					@ApiResponse(responseCode = "404", description = "Not found")}
		)
	public ResponseEntity<FuncionarioDTO> update(@PathVariable Integer id, @RequestBody FuncionarioDTO objDTO){
		objDTO.setId(id);
		return ResponseEntity.ok().body(mapper.map(funcionarioService.update(objDTO), FuncionarioDTO.class));
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(
			tags = {"Funcionario"},
			responses = {@ApiResponse(responseCode = "204", description = "Success"),
					@ApiResponse(responseCode = "404", description = "Not found")}
		)
	public ResponseEntity<FuncionarioDTO> delete(@PathVariable Integer id){
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
