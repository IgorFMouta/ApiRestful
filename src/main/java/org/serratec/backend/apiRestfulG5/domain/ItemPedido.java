package org.serratec.backend.apiRestfulG5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_pedido", schema = "public")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_item_pedido;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "preco_venda", nullable = false)
	private Double preco_venda;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
}
