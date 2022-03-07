package br.com.funcionario.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.repositories.FuncionarioRepository;
import br.com.funcionario.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Funcionario findById(Integer id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElse(null);
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
	
	

}
