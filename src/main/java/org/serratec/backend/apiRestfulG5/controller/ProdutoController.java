package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.Produto;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
import org.serratec.backend.apiRestfulG5.exception.ProdutoNotFoundException;
import org.serratec.backend.apiRestfulG5.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Produto produto) {
		produtoService.inserir(produto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Produto> listar() {
		return produtoService.listar();
	}
	
	@GetMapping("/{id}")
	public Produto listarPorId(@PathVariable Long id_produto) throws ProdutoNotFoundException {
		return produtoService.listarPorId(id_produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id_produto, @RequestBody(required = true) Produto produto)
			throws ProdutoNotFoundException, ParametroObrigatorioException {
		produtoService.atualizar(id_produto, produto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable Long id_produto) throws ProdutoNotFoundException {
		produtoService.deletarPorId(id_produto);
	}
}