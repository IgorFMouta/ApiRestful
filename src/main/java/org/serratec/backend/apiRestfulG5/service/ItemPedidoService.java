package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.ItemPedido;
import org.serratec.backend.apiRestfulG5.exception.ItemPedidoNotFoundException;
import org.serratec.backend.apiRestfulG5.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public ItemPedido inserir(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	

	public List<ItemPedido> listar() {
		return itemPedidoRepository.findAll();
	}
	

	public ItemPedido listarPorId(Integer id_item_pedido) throws ItemPedidoNotFoundException {
		Optional<ItemPedido> opItemPedido = itemPedidoRepository.findById(id_item_pedido);
		
		if(opItemPedido.isPresent()) {
			return opItemPedido.get();
		}
		
		throw new ItemPedidoNotFoundException("A relação de item e pedido " + id_item_pedido + " não foi encontrada");
	}
	

	public ItemPedido substituir(Integer id_item_pedido, ItemPedido itemPedido) throws ItemPedidoNotFoundException {
		
		ItemPedido itemPedidoNoBanco = listarPorId(id_item_pedido);
		
		if(itemPedido.getId_item_pedido() != null) {
			itemPedidoNoBanco.setId_item_pedido(itemPedido.getId_item_pedido());
		}
		
		if(itemPedido.getQuantidade() != null) {
			itemPedidoNoBanco.setQuantidade(itemPedido.getQuantidade());
		}
		
		if(itemPedido.getPreco_venda() != null) {
			itemPedidoNoBanco.setPreco_venda(itemPedido.getPreco_venda());
		}
		
		if(itemPedido.getPedido() != null) {
			itemPedidoNoBanco.setPedido(itemPedido.getPedido());
		}
		
		if(itemPedido.getProduto() != null) {
			itemPedidoNoBanco.setProduto(itemPedido.getProduto());
		}
		
		return itemPedidoRepository.save(itemPedidoNoBanco);
	}
	

	public void deletar(Integer id_item_pedido) throws ItemPedidoNotFoundException {
		itemPedidoRepository.deleteById(id_item_pedido);
	}
	
}
