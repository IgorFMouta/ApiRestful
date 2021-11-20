package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.ItemPedido;
import org.serratec.backend.apiRestfulG5.domain.Pedido;
import org.serratec.backend.apiRestfulG5.exception.DataNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ItemPedidoNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.exception.PedidoNotFoundException;
import org.serratec.backend.apiRestfulG5.service.ItemPedidoService;
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

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;
	

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody ItemPedido itemPedido) {
		itemPedidoService.inserir(itemPedido);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<ItemPedido> listar() {
		return itemPedidoService.listar();
	}
	
	@GetMapping("/{id_item_pedido}")
	public ItemPedido listarPorId(@PathVariable Integer id_item_pedido) throws ItemPedidoNotFoundException, DataNotFoundException {
		return itemPedidoService.listarPorId(id_item_pedido);
	}
	
	@PutMapping("/{id_item_pedido}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id_item_pedido, @RequestBody(required = true) ItemPedido itemPedido)
			throws ItemPedidoNotFoundException, ParameterException, DataNotFoundException {
		itemPedidoService.substituir(id_item_pedido, itemPedido);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_item_pedido}")
	public void deletar(@PathVariable Integer id_item_pedido) throws ItemPedidoNotFoundException, DataNotFoundException {
		itemPedidoService.deletar(id_item_pedido);
	}

	
	
}
