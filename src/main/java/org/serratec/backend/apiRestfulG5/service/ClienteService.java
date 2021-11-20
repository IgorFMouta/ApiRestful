package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Cliente;
import org.serratec.backend.apiRestfulG5.exception.ClienteNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
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
	
	public Cliente pesquisarPorId(Integer id_cliente) throws ClienteNotFoundException {
		Optional<Cliente> opCliente = clienteRepository.findById(id_cliente);

		if(opCliente.isPresent()) {
			return opCliente.get();
		}
		
		throw new ClienteNotFoundException("Cliente com id " + id_cliente + " não encontrada");
	}
	public Cliente atualizar(Integer id_cliente, Cliente cliente) throws ParameterException, ClienteNotFoundException {
		if(cliente == null) throw new ParameterException("Campo 'Cliente' é obrigatório");
		
		Cliente cliente1 = pesquisarPorId(id_cliente);
		
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
	
	public void deletarPorId(Integer id_cliente) throws ClienteNotFoundException{
		clienteRepository.deleteById(id_cliente);
	}
}

