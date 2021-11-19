package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Endereco;
import org.serratec.backend.apiRestfulG5.exception.EnderecoNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
import org.serratec.backend.apiRestfulG5.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco inserir(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}
	
	public Endereco pesquisarPorId(Integer id) throws EnderecoNotFoundException {
		Optional<Endereco> opEndereco = enderecoRepository.findById(id);

		if(opEndereco.isPresent()) {
			return opEndereco.get();
		}
		
		throw new EnderecoNotFoundException("Endereco com id " + id + " não encontrada");
	}
	public Endereco atualizar(Integer id, Endereco endereco) throws ParametroObrigatorioException, EnderecoNotFoundException {
		if(endereco == null) throw new ParametroObrigatorioException("Campo 'Endereco' é obrigatório");
		
		Endereco endereco1 = pesquisarPorId(id);
		
		if(endereco.getCep() != null) {
			endereco1.setCep(endereco.getCep());
		}
		
		if(endereco.getRua() != null) {
			endereco1.setRua(endereco.getRua());
		}
		
		if(endereco.getNumero() != null) {
			endereco1.setNumero(endereco.getNumero());
		}
		
		if(endereco.getComplemento() != null) {
			endereco1.setComplemento(endereco.getComplemento());
		}
		
		if(endereco.getBairro() != null) {
			endereco1.setBairro(endereco.getBairro());
		}
		
		if(endereco.getCidade() != null) {
			endereco1.setCidade(endereco.getCidade());
		}
		
		if(endereco.getEstado() != null) {
			endereco1.setEstado(endereco.getEstado());
		}
		
		return enderecoRepository.save(endereco1);
	}
	
	public void deletarPorId(Integer id) throws EnderecoNotFoundException{
		Endereco endereco1 = pesquisarPorId(id);
		enderecoRepository.delete(endereco1);
	
	}
}
