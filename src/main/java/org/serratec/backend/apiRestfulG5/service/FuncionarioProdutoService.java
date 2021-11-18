package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.apiRestfulG5.domain.FuncionarioProduto;
import org.serratec.backend.apiRestfulG5.exception.TestException;
import org.serratec.backend.apiRestfulG5.repository.FuncionarioProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioProdutoService {

	@Autowired
	private FuncionarioProdutoRepository funcionarioProdutoRepository;
	private FuncionarioProdutoService findById(Long idFuncionarioProduto) throws TestException{
		Optional<FuncionarioProduto> funcionarioproduto = funcionarioProdutoRepository.findById(idFuncionarioProduto);
		if(funcionarioproduto.isPresent()) {
			return funcionarioproduto.get();
		}
		throw new TestException();
	}
	
	public FuncionarioProduto buscarPorIdFP(Long id) throws TestException{
		return findById(idFuncionarioProdutoFP);
	}
	
	public List<FuncionarioProduto> buscarTodosFP(){
		return funcionarioProdutoRepository.findAll();
	}
	
	@Transactional
	public FuncionarioProduto inserirFP(FuncionarioProduto funcionarioProduto) {
		return funcionarioProdutoRepository.save(funcionarioProduto);
	}
	
	@Transactional
	public FuncionarioProduto atualizarFP(Long idFuncionarioProduto, FuncionarioProduto funcionarioProduto) throws TestException{
		FuncionarioProduto funcionarioProduto2 = findById(idFuncionarioProduto);
		funcionarioProduto.setFuncionario(funcionarioProduto.getFuncionario());
		funcionarioProduto.setPedido(funcionarioProduto.getIdFuncionarioPedido());
		return funcionarioProdutoRepository.save(funcionarioProduto);
	}
	
	public void apagarFP (Long idFuncionarioProduto) throws TestException{
		FuncionarioProduto funcionarioProduto = findById(idFuncionarioProduto);
		funcionarioProdutoRepository.delete(funcionarioProduto);
	}
	
	
	
}
