package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Produto;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
import org.serratec.backend.apiRestfulG5.exception.ProdutoNotFoundException;
import org.serratec.backend.apiRestfulG5.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public Produto inserir(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	

		
		
		
		


}
	

