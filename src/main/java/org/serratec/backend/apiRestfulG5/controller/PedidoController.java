package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;
import org.serratec.backend.apiRestfulG5.exception.DataNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.exception.PedidoNotFoundException;
import org.serratec.backend.apiRestfulG5.domain.Pedido;
import org.serratec.backend.apiRestfulG5.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Pedido pedido) {
		pedidoService.inserir(pedido);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Pedido> listar() {
		return pedidoService.listar();
	}
	
	@GetMapping("/{id_pedido}")
	public Pedido listarPorId(@PathVariable Integer id_pedido) throws PedidoNotFoundException, DataNotFoundException {
		return pedidoService.listarPorid(id_pedido);
	}
	
	@PutMapping("/{id_pedido}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id_pedido, @RequestBody(required = true) Pedido pedido)
			throws PedidoNotFoundException, ParameterException, DataNotFoundException {
		pedidoService.substituir(id_pedido, pedido);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_pedido}")
	public void deletar(@PathVariable Integer id_pedido) throws PedidoNotFoundException, DataNotFoundException {
		pedidoService.deletar(id_pedido);
	}

}
