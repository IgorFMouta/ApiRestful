package org.serratec.backend.apiRestfulG5.domain;

import java.util.Objects;

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
	@Column(name = "id_item_pedido", nullable = false, unique = true)
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

	public Integer getId_item_pedido() {
		return id_item_pedido;
	}

	public void setId_item_pedido(Integer id_item_pedido) {
		this.id_item_pedido = id_item_pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [id_item_pedido=" + id_item_pedido + ", quantidade=" + quantidade + ", preco_venda="
				+ preco_venda + ", produto=" + produto + ", pedido=" + pedido + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_item_pedido, pedido, preco_venda, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id_item_pedido, other.id_item_pedido) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(preco_venda, other.preco_venda) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade, other.quantidade);
	}
	
	
	
}