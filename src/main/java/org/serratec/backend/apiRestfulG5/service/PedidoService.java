package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.exception.DataNotFoundException;
import org.serratec.backend.apiRestfulG5.domain.Pedido;
import org.serratec.backend.apiRestfulG5.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido inserir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	public Pedido listarPorid(Integer id_pedido) throws DataNotFoundException {
		Optional<Pedido> opPedido = pedidoRepository.findById(id_pedido);

		if (opPedido.isPresent()) {
			return opPedido.get();
		}

		throw new DataNotFoundException("Pedido com código " + id_pedido + " não encontrada");
	}

	public Pedido substituir(Integer id_pedido, Pedido pedido)
			throws ParameterException, DataNotFoundException {
		if (pedido == null)
			throw new ParameterException("Campo 'Pedido' é obrigatório");

		Pedido pedidoNoBanco = listarPorid(id_pedido);


		if (pedido.getId_pedido() != null) {
			pedidoNoBanco.setId_pedido(pedido.getId_pedido());
		}

		if (pedido.getDataPedido() != null) {
			pedidoNoBanco.setDataPedido(pedido.getDataPedido());
		}

		if (pedido.getValor() != null) {
			pedidoNoBanco.setValor(pedido.getValor());
		}

		return pedidoRepository.save(pedidoNoBanco);
	}

	public void deletar(Integer id_pedido) throws DataNotFoundException {
		pedidoRepository.deleteById(id_pedido);
	}
}
