package br.com.funcionario.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.repositories.FuncionarioRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Bean
	public void startDB() {
		Funcionario f1 = new Funcionario(null, "Maria","11111111111", "maria@email.com", 50.00);
		Funcionario f2 = new Funcionario(null, "Joao","22222222222", "joao@email.com", 60.00);
		Funcionario f3 = new Funcionario(null, "Jose","33333333333", "jose@email.com", 100.00);
		
		
		funcionarioRepository.saveAll(List.of(f1, f2, f3));
	}

}
