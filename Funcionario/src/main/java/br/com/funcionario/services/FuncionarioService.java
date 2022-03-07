package br.com.funcionario.services;

import java.util.List;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.domain.dto.FuncionarioDTO;

public interface FuncionarioService {
	
	Funcionario findById(Integer id);
	List<Funcionario> findAll();
	Funcionario create(FuncionarioDTO objDTO);

}
