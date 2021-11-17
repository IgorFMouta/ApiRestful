package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.apiRestfulG5.domain.Cliente;
import org.serratec.backend.apiRestfulG5.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> pesquisarPorId(@PathVariable Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody Cliente cliente){
		clienteRepository.save(cliente);
		return cliente;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
		Optional<Cliente> cliente1 = clienteRepository.findById(id);
			if(cliente1.isPresent()) {
			if(null != cliente.getNome_cliente()) {
				cliente1.get().setNome_cliente(cliente.getNome_cliente());
			}
			if(null != cliente.getNome_usuario()) {
				cliente1.get().setNome_usuario(cliente.getNome_usuario());
			}
			if(null != cliente.getEmail()) {
				cliente1.get().setEmail(cliente.getEmail());
			}
			if(null != cliente.getSenha()) {
				cliente1.get().setSenha(cliente.getSenha());
			}
			if(null != cliente.getCpf()) {
				cliente1.get().setCpf(cliente.getCpf());
			}
			if(null != cliente.getDataNasc()) {
				cliente1.get().setDataNasc(cliente.getDataNasc());
			}
			if(null != cliente.getTelefone()) {
				cliente1.get().setTelefone(cliente.getTelefone());
			}
		}
			else {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(clienteRepository.save(cliente1.get()));
		}
	@DeleteMapping("{id}")
	public ResponseEntity <Void> deletarPorId(@PathVariable Long id){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

