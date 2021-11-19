package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Produto;
import org.serratec.backend.apiRestfulG5.exception.ParametroObrigatorioException;
import org.serratec.backend.apiRestfulG5.exception.ProdutoNotFoundException;
import org.serratec.backend.apiRestfulG5.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	
	public Produto listarPorId(Long id_produto) throws ProdutoNotFoundException {
		Optional<Produto> opProduto = produtoRepository.findById(id_produto);
		
		if(opProduto.isPresent()) {
			return opProduto.get();
		}
		
		throw new ProdutoNotFoundException("O cliente com a id " + id_produto + " não foi encontrado");
		
	}
		
	public Produto inserir(Produto produto) {
		return produtoRepository.save(produto);
	}

	
	public Produto atualizar(Long id_produto, Produto produto) throws ParametroObrigatorioException, ProdutoNotFoundException{
		if(produto == null) throw new ParametroObrigatorioException("Campo 'Produto' é obrigatório");
	
		Produto produtoBanco = listarPorId(id_produto);
		
		if(produto.getNome() != null) {
			produtoBanco.setNome(produto.getNome());
		}
		
		if(produto.getDescricao() != null) {
			produtoBanco.setDescricao(produto.getDescricao());
		}
		
		if(produto.getQtd_estoque() != null) {
			produtoBanco.setQtd_estoque(produto.getQtd_estoque());
		}
		
		if(produto.getData_cadastro() != null) {
			produtoBanco.setData_cadastro(produto.getData_cadastro());
		}
		
		if(produto.getValor_unitario() != null) {
			produtoBanco.setValor_unitario(produto.getValor_unitario());
		}
		
		if(produto.getImage() != null) {
			produtoBanco.setImage(produto.getImage());
		}
		
		return produtoRepository.save(produtoBanco);		
	}
		
	
	public void deletarPorId(Long id_produto) throws ProdutoNotFoundException{
		Produto produtoBanco = listarPorId(id_produto);
		produtoRepository.delete(produtoBanco);
	}
	
	
		


}
	

