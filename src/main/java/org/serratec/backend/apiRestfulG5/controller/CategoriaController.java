package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.Categoria;
import org.serratec.backend.apiRestfulG5.exception.CategoriaNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
import org.serratec.backend.apiRestfulG5.service.CategoriaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Categoria categoria) {
	    categoriaService.inserir(categoria);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listar();
	}
	
	@GetMapping("/{id}")
	public Categoria listarPorId(@PathVariable Long id_categoria) throws CategoriaNotFoundException {
		return categoriaService.listarPorId(id_categoria);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id_categoria, @RequestBody(required = true) Categoria categoria)
			throws CategoriaNotFoundException, ParametroObrigatorioException {
		categoriaService.atualizar(id_categoria, categoria);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable Long id_categoria) throws CategoriaNotFoundException {
		categoriaService.deletarPorId(id_categoria);
	}
}