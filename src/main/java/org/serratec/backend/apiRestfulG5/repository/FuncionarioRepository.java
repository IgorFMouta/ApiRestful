package org.serratec.backend.apiRestfulG5.repository;

import org.serratec.backend.apiRestfulG5.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends 	JpaRepository<Funcionario, Long> {
	
}
