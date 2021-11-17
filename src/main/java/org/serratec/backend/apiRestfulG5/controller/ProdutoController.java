package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.apiRestfulG5.domain.Produto;
import org.serratec.backend.apiRestfulG5.repository.ProdutoRepository;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository ProdutoRepository;


	@GetMapping
	@ApiOperation(value="Lista todos os produtos", notes= "Listagem de produtos")
	@ApiResponses(value = {
			@ApiResponse(code= 200, message ="Retorna todos os produtos"),
			@ApiResponse(code= 401, message= "Erro de autenticaÃ§Ã£o"),
			@ApiResponse(code= 403, message= "VocÃª nÃ£o tem permissÃ£o para acessar o recurso"),
			@ApiResponse(code= 404, message= "Recurso nÃ£o encontrado"),
			@ApiResponse(code= 405, message= "Quando ocorre uma exceÃ§Ã£o")
	})
	public List <Produto> listarTodos(){
		return ProdutoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> listarPorId(@PathVariable Long id_produto) {
		Optional<Produto> produto = ProdutoRepository.findById(id_produto);
		if(produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
			}
			return ResponseEntity.notFound().build();
		} 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@Valid @RequestBody Produto produto){
		ProdutoRepository.save(produto);
		return produto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id_produto, @Valid @RequestBody Produto produto){
		Optional<Produto> produto1 = ProdutoRepository.findById(id_produto);
			if(produto1.isPresent()) {
			if(null != produto.getNome()) {
				produto1.get().setNome(produto.getNome());
			}
			if(null != produto.getDescricao()) {
				produto1.get().setDescricao(produto.getDescricao());
			}
			if(null != produto.getQtd_estoque()) {
				produto1.get().setQtd_estoque(produto.getQtd_estoque());
			}
			if(null != produto.getData_cadastro()) {
				produto1.get().setData_cadastro(produto.getData_cadastro());
			}
			if(null != produto.getValor_unitario()) {
				produto1.get().setValor_unitario(produto.getValor_unitario());
			}
		}
		else {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ProdutoRepository.save(produto1.get()));
	}
	@DeleteMapping("{id}")
	public ResponseEntity <Void> deletarPorId(@PathVariable Long id_produto){
		if(!ProdutoRepository.existsById(id_produto)) {
			return ResponseEntity.notFound().build();
		}
		ProdutoRepository.deleteById(id_produto);
		return ResponseEntity.noContent().build();
	}
	

	
}
