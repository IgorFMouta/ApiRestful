package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;
import org.serratec.backend.apiRestfulG5.domain.Funcionario;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
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
	
	public Funcionario pesquisarPorId(Integer id) throws FuncionarioNotFoundException {
		Optional<Funcionario> opFuncionario = funcionarioRepository.findById(id);

		if(opFuncionario.isPresent()) {
			return opFuncionario.get();
		}
		
		throw new FuncionarioNotFoundException("Funcionario com id " + id + " não encontrada");
	}
	public Funcionario atualizar(Integer id, Funcionario funcionario) throws ParametroObrigatorioException, funcionarioNotFoundException {
		if(funcionario == null) throw new ParametroObrigatorioException("Campo 'Funcionario' é obrigatório");
		
		Funcionario funcionario1 = pesquisarPorId(id);
		
		if(funcionario.getNome_funcionario() != null) {
			funcionario1.setNome_funcionario(funcionario.getNome_funcionario());
		}
		
		if(funcionario.getCpf_funcionario() != null) {
			funcionario1.setCpf_funcionario(funcionario.getCpf_funcionario());
		}
		
		return funcionarioRepository.save(funcionario1);
	}
	
	public void deletarPorId(Integer id) throws FuncionarioNotFoundException{
		Funcionario funcionario1 = pesquisarPorId(id);
		funcionarioRepository.delete(funcionario1);
	}
}