package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;
import org.serratec.backend.apiRestfulG5.domain.Funcionario;
import org.serratec.backend.apiRestfulG5.exception.FuncionarioNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario inserir(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario pesquisarPorId(Integer id_funcionario) throws FuncionarioNotFoundException {
		Optional<Funcionario> opFuncionario = funcionarioRepository.findById(id_funcionario);

		if(opFuncionario.isPresent()) {
			return opFuncionario.get();
		}
		
		throw new FuncionarioNotFoundException("Funcionario com id " + id_funcionario + " não encontrada");
	}
	public Funcionario atualizar(Integer id_funcionario, Funcionario funcionario) throws ParameterException, FuncionarioNotFoundException {
		if(funcionario == null) throw new ParameterException("Campo 'Funcionario' é obrigatório");
		
		Funcionario funcionario1 = pesquisarPorId(id_funcionario);
		
		if(funcionario.getNome() != null) {
			funcionario1.setNome(funcionario.getNome());
		}
		
		if(funcionario.getCpf() != null) {
			funcionario1.setCpf(funcionario.getCpf());
		}
		
		return funcionarioRepository.save(funcionario1);
	}
	
	public void deletarPorId(Integer id_funcionario) throws FuncionarioNotFoundException{
		funcionarioRepository.deleteById(id_funcionario);
	}
}