package org.serratec.backend.apiRestfulG5.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FuncionarioPedido")
public class FuncionarioProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionarioPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id", nullable = false)
	private Funcionario funcionario;

	
	public FuncionarioProduto() {
		super();
	}

	public FuncionarioProduto(Long idFuncionarioPedido, Pedido pedido, Funcionario funcionario) {
		super();
		this.idFuncionarioPedido = idFuncionarioPedido;
		this.pedido = pedido;
		this.funcionario = funcionario;
	}

	public Long getIdFuncionarioPedido() {
		return idFuncionarioPedido;
	}

	public void setIdFuncionarioPedido(Long idFuncionarioPedido) {
		this.idFuncionarioPedido = idFuncionarioPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFuncionarioPedido, pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioProduto other = (FuncionarioProduto) obj;
		return Objects.equals(idFuncionarioPedido, other.idFuncionarioPedido) && Objects.equals(pedido, other.pedido);
	}
	
	
	
	
	
	
	
	
	
	
}
