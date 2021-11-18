package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.apiRestfulG5.domain.Categoria;
import org.serratec.backend.apiRestfulG5.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaRepository CategoriaRepository;

	
	@GetMapping
	public List <Categoria> listarTodos(){
		return CategoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> listarPorId(@PathVariable Long id_categoria) {
		Optional<Categoria> categoria = CategoriaRepository.findById(id_categoria);
		if(categoria.isPresent()) {
			return ResponseEntity.ok(categoria.get());
			}
			return ResponseEntity.notFound().build();
		} 
	@PostMapping
	//@ResponseBody(HttpStatus.CREATED) está dando erro
	public Categoria inserir(@Valid @RequestBody Categoria categoria){
		CategoriaRepository.save(categoria);
		return categoria;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id_categoria, @Valid @RequestBody Categoria categoria){
		Optional<Categoria> categoria1 = CategoriaRepository.findById(id_categoria);
			if(categoria1.isPresent()) {
			if(null != categoria.getNome()) {
				categoria1.get().setNome(categoria.getNome());
			}
			if(null != categoria.getDescricao()) {
				categoria1.get().setDescricao(categoria.getDescricao());
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(CategoriaRepository.save(categoria1.get()));
	}
	@DeleteMapping("{id}")
	public ResponseEntity <Void> deletarPorId(@PathVariable Long id_categoria){
		if(!CategoriaRepository.existsById(id_categoria)) {
			return ResponseEntity.notFound().build();
		}
		CategoriaRepository.deleteById(id_categoria);
		return ResponseEntity.noContent().build();
	}
	

}
