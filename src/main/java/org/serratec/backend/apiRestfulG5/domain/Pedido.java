package org.serratec.backend.apiRestfulG5.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.serratec.backend.apiRestfulG5.enums.PedidoStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer IdPedido;
	
	@Column(name="Data_Pedido")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataPedido;
	
	@Column(name="Status", nullable = false)
	private PedidoStatus pedidoStatus;
	
	@Column(name="Valor")
	private Double valor;
	
	@Column(name="Codigo_Cliente", nullable = false)
	private Integer idCliente;
	
	public Integer getIdPedido() {
		return IdPedido;
	}
	public void setIdPedido(Integer IdPedido) {
		this.IdPedido = IdPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
}

