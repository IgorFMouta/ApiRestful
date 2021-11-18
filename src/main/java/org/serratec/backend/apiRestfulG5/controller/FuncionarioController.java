package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.apiRestfulG5.domain.Funcionario;
import org.serratec.backend.apiRestfulG5.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/funcionario")	    
public class FuncionarioController {
	
	    @Autowired
	    private FuncionarioRepository funcionarioRepository;
	    
	    @GetMapping
	    public List<Funcionario> listarTodos(){
	        return funcionarioRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Funcionario> pesquisarPorId(@PathVariable Long id){
	        Optional<Funcionario> cliente = funcionarioRepository.findById(id);
	        if(cliente.isPresent()) {
	            return ResponseEntity.ok(cliente.get());
	        }
	        return ResponseEntity.notFound().build();
	    }
	    
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Funcionario inserir(@Valid @RequestBody Funcionario funcionario){
	    	funcionarioRepository.save(funcionario);
	        return funcionario;
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario){
	        Optional<Funcionario> funcionario1 = funcionarioRepository.findById(id);
	            if(funcionario1.isPresent()) {
	            if(null != funcionario.getCpf()) {
	            	funcionario1.get().setCpf(funcionario.getCpf());
	            }
	            if(null != funcionario.getNome()) {
	            	funcionario1.get().setNome(funcionario.getNome());
	          
	        }
	            }
	            else {
	                return ResponseEntity.notFound().build();
	            }
	            return ResponseEntity.ok(funcionarioRepository.save(funcionario1.get()));
	        }
	    @DeleteMapping("{id}")
	    public ResponseEntity <Void> deletarPorId(@PathVariable Long id){
	        if(!funcionarioRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        funcionarioRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
