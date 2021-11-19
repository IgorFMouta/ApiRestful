package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Cliente;
import org.serratec.backend.apiRestfulG5.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente inserir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente pesquisarPorId(Integer id) throws ClienteNotFoundException {
		Optional<Cliente> opCliente = clienteRepository.findById(id);

		if(opCliente.isPresent()) {
			return opCliente.get();
		}
		
		throw new ClienteNotFoundException("Cliente com id " + id + " não encontrada");
	}
	public Cliente atualizar(Integer id, Cliente cliente) throws ParametroObrigatorioException, ClienteNotFoundException {
		if(cliente == null) throw new ParametroObrigatorioException("Campo 'Cliente' é obrigatório");
		
		Cliente cliente1 = pesquisarPorId(id);
		
		if(cliente.getNome_cliente() != null) {
			cliente1.setNome_cliente(cliente.getNome_cliente());
		}
		
		if(cliente.getNome_usuario() != null) {
			cliente1.setNome_usuario(cliente.getNome_usuario());
		}
		
		if(cliente.getEmail() != null) {
			cliente1.setEmail(cliente.getEmail());
		}
		
		if(cliente.getSenha() != null) {
			cliente1.setSenha(cliente.getSenha());
		}
		
		if(cliente.getCpf() != null) {
			cliente1.setCpf(cliente.getCpf());
		}
		
		if(cliente.getDataNasc() != null) {
			cliente1.setDataNasc(cliente.getDataNasc());
		}
		
		if(cliente.getTelefone() != null) {
			cliente1.setTelefone(cliente.getTelefone());
		}
		
		return clienteRepository.save(cliente1);
	}
	
	public void deletarPorId(Integer id) throws ClienteNotFoundException{
		Cliente cliente1 = pesquisarPorId(id);
		clienteRepository.deletarPorId(cliente1);
	}
}

