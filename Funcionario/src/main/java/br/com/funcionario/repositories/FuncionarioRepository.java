package br.com.funcionario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.funcionario.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	Optional<Funcionario> findByEmail(String email);

	Optional<Funcionario> findByCpf(String cpf);

}
