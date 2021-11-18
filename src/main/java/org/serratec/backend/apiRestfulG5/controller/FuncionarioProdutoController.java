package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.apiRestfulG5.domain.FuncionarioProduto;
import org.serratec.backend.apiRestfulG5.exception.TestException;
import org.serratec.backend.apiRestfulG5.service.FuncionarioProdutoService;
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
@RequestMapping("/funcionarioProduto")
public class FuncionarioProdutoController {
	
	@Autowired
	FuncionarioProdutoService funcionarioProdutoService;
	
	@GetMapping
	public List<FuncionarioProduto> buscarTodosFP(){
		return FuncionarioProdutoService.buscarTodosFP();
	}
	
	@GetMapping("/{idFuncionarioProduto}")
	public ResponseEntity<FuncionarioProduto> FuncionarioProduto buscarPorIdFP(@PathVariable Long idFuncionarioProduto) throws TestException{
		return funcionarioProdutoService.buscarPorId(idFuncionarioProduto);
	}
	
	
	@PostMapping
	public FuncionarioProduto inserirFP(@Valid @RequestBody FuncionarioProduto funcionarioProduto) {
		return funcionarioProdutoService.inserirFuncionarioProduto(FuncionarioProduto);
	}
	
	@PutMapping("/{idFuncionarioProduto}")
	public FuncionarioProduto atualizarFP(@PathVariable Long idFuncionarioProduto, @Valid @RequestBody FuncionarioProduto funcionarioProduto)
	throws TestException{
		return funcionarioProdutoService.atualizarFuncionarioProduto(idFuncionarioProduto, FuncionarioProduto);
	}
	
	
	@DeleteMapping("/{idFuncionarioProduto}")
	public ResponseEntity apagarFP(@PathVariable Long idFuncionarioProduto)
	throws TestException{
		funcionarioProdutoService.apagarFuncionarioProduto(idFuncionarioProduto);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
