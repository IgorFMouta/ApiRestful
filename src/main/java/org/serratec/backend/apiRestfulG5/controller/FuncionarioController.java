package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.Funcionario;
import org.serratec.backend.apiRestfulG5.exception.FuncionarioNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
import org.serratec.backend.apiRestfulG5.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	@ApiOperation(value="Lista todos os funcionario", notes= "Listagem de funcionario")
	@ApiResponses(value = {
			@ApiResponse(code= 200, message ="Retorna todos os funcionario"),
			@ApiResponse(code= 401, message= "Erro de autenticação"),
			@ApiResponse(code= 403, message= "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code= 404, message= "Recurso não encontrado"),
			@ApiResponse(code= 405, message= "Quando ocorre uma exceção")
	})
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Funcionario funcionario) {
		funcionarioService.inserir(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	public List<Funcionario> listarTodos(){
		return funcionarioService.listar();
	}

	@GetMapping("/{id}")
	public Funcionario pesquisarPorId(@PathVariable Integer id) throws FuncionarioNotFoundException {
		return funcionarioService.pesquisarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody(required = true) Funcionario funcionario)
			throws FuncionarioNotFoundException, ParametroObrigatorioException {
		funcionarioService.atualizar(id, funcionario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable Integer id) throws FuncionarioNotFoundException {
		funcionarioService.deletarPorId(id);
	}
}