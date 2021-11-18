package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.serratec.backend.apiRestfulG5.exception.DataNotFoundException;
import org.serratec.backend.apiRestfulG5.domain.Pedido;
import org.serratec.backend.apiRestfulG5.model.DTO.PedidoDTO;
import org.serratec.backend.apiRestfulG5.model.DTO.PedidoSimplesDTO;
import org.serratec.backend.apiRestfulG5.repository.PedidoRepository;
import org.serratec.backend.apiRestfulG5.mapper.PedidoMapper;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoMapper pedidoMapper;

	private Pedido findBy(Integer id) throws DataNotFoundException {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		if (optionalPedido.isPresent()) {
			return optionalPedido.get();
		}
		throw new DataNotFoundException(String.format("Pedido com id %d não encontrado", id)) ;
	}

	@Transactional
	public PedidoDTO inserir(PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
		Pedido pedidoSalvoNoBd = pedidoRepository.save(pedido);
		return pedidoMapper.toDTO(pedidoSalvoNoBd);
	}
	
	public List<PedidoSimplesDTO> listar() {
		return pedidoRepository.findAll()
		    .stream()
		    .map(pedidoMapper::toSimplesDTO)
		    .collect(toList());
	}
	
	public PedidoDTO listarPorId(Integer id) throws DataNotFoundException {
		return pedidoMapper.toDTO(findBy(id));
	}
	
	
	@Transactional
	public void deletar(Integer id) throws DataNotFoundException {
		Pedido pedidoNoBanco = findBy(id);
		pedidoRepository.delete(pedidoNoBanco);
	}

}
