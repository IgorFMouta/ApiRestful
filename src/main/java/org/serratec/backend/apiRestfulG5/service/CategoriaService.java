package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Categoria;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.exception.CategoriaNotFoundException;
import org.serratec.backend.apiRestfulG5.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
     CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	
	public Categoria listarPorId(Integer id_categoria) throws CategoriaNotFoundException {
		Optional<Categoria> opCategoria = categoriaRepository.findById(id_categoria);
		
		if(opCategoria.isPresent()) {
			return opCategoria.get();
		}
		
		throw new CategoriaNotFoundException("O cliente com a id " + id_categoria + " não foi encontrado");
		
	}
		
	public Categoria inserir(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	
	public Categoria substituir(Integer id_categoria, Categoria categoria) throws ParameterException, CategoriaNotFoundException{
		if(categoria == null) throw new ParameterException("Campo 'Categoria' é obrigatório");
	
		Categoria categoriaBanco = listarPorId(id_categoria);
		
		if(categoria.getNome() != null) {
			categoriaBanco.setNome(categoria.getNome());
		}
		
		if(categoria.getDescricao() != null) {
			categoriaBanco.setDescricao(categoria.getDescricao());
		}
	
		return categoriaRepository.save(categoriaBanco);		
	}
		
	public void deletar(Integer id_categoria) throws CategoriaNotFoundException{
//		Categoria categoriaBanco = listarPorId(id_categoria);
		categoriaRepository.deleteById(id_categoria);
	}

}
