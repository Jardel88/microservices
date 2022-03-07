package br.com.funcionario.services;

import java.util.List;

import br.com.funcionario.domain.Funcionario;

public interface FuncionarioService {
	
	Funcionario findById(Integer id);
	List<Funcionario> findAll();

}
