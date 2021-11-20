package org.serratec.backend.apiRestfulG5.controller;


import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.Endereco;
import org.serratec.backend.apiRestfulG5.exception.EnderecoNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.service.EnderecoService;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	@ApiOperation(value="Lista todos os enderecos", notes= "Listagem de enderecos")
	@ApiResponses(value = {
			@ApiResponse(code= 200, message ="Retorna todos os enderecos"),
			@ApiResponse(code= 401, message= "Erro de autenticação"),
			@ApiResponse(code= 403, message= "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code= 404, message= "Recurso não encontrado"),
			@ApiResponse(code= 405, message= "Quando ocorre uma exceção")
	})
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Endereco endereco) {
		enderecoService.inserir(endereco);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	public List<Endereco> listarTodos(){
		return enderecoService.listar();
	}

	@GetMapping("/{id}")
	public Endereco pesquisarPorId(@PathVariable Integer id) throws EnderecoNotFoundException {
		return enderecoService.pesquisarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody(required = true) Endereco endereco)
			throws EnderecoNotFoundException, ParameterException {
		enderecoService.atualizar(id, endereco);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable Integer id) throws EnderecoNotFoundException {
		enderecoService.deletarPorId(id);
	}
}

