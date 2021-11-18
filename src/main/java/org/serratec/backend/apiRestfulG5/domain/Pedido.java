package org.serratec.backend.apiRestfulG5.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.serratec.backend.apiRestfulG5.enums.PedidoStatus;

import lombok.Data;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_pedido")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;

	@Column(name="status", nullable = false)
	private PedidoStatus pedidoStatus;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();


	@Transient
	public Double getTotal() {
		double soma = 0.0;
		for(ItemPedido item : itens) {
			soma += item.getSubTotal();
		}
		return soma;
	}

	
	
}