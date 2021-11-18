package org.serratec.backend.apiRestfulG5.controller;


import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.serratec.backend.apiRestfulG5.domain.Endereco;
import org.serratec.backend.apiRestfulG5.repository.EnderecoRepository;
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
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> pesquisarPorId(@PathVariable Long id){
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco inserir(@Valid @RequestBody Endereco endereco){
		enderecoRepository.save(endereco);
		return endereco;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @Valid @RequestBody Endereco endereco){
		Optional<Endereco> endereco1 = enderecoRepository.findById(id);
			if(endereco1.isPresent()) {
			if(null != endereco.getCep()) {
				endereco1.get().setCep(endereco.getCep());
			}
			if(null != endereco.getRua()) {
				endereco1.get().setRua(endereco.getRua());
			}
			if(null != endereco.getNumero()) {
				endereco1.get().setNumero(endereco.getNumero());
			}
			if(null != endereco.getComplemento()) {
				endereco1.get().setComplemento(endereco.getComplemento());
			}
			if(null != endereco.getBairro()) {
				endereco1.get().setBairro(endereco.getBairro());
			}
			if(null != endereco.getCidade()) {
				endereco1.get().setCidade(endereco.getCidade());
			}
			if(null != endereco.getEstado()) {
				endereco1.get().setEstado(endereco.getEstado());
			}
		}
			else {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(enderecoRepository.save(endereco1.get()));
		}
	@DeleteMapping("{id}")
	public ResponseEntity <Void> deletarPorId(@PathVariable Long id){
		if(!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
