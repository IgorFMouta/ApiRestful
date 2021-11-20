package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.Cliente;
import org.serratec.backend.apiRestfulG5.exception.ClienteNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ApiOperation(value="Lista todos os clientes", notes= "Listagem de clientes")
	@ApiResponses(value = {
			@ApiResponse(code= 200, message ="Retorna todos os clientes"),
			@ApiResponse(code= 401, message= "Erro de autenticação"),
			@ApiResponse(code= 403, message= "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code= 404, message= "Recurso não encontrado"),
			@ApiResponse(code= 405, message= "Quando ocorre uma exceção")
	})

	public List<Cliente> listarTodos(){
		return clienteService.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Cliente cliente) {
		clienteService.inserir(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@GetMapping("/{id}")
	public Cliente pesquisarPorId(@PathVariable Integer id) throws ClienteNotFoundException {
		return clienteService.pesquisarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody(required = true) Cliente cliente)
			throws ClienteNotFoundException, ParameterException {
		clienteService.atualizar(id, cliente);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable Integer id) throws ClienteNotFoundException {
		clienteService.deletarPorId(id);
	}
}

