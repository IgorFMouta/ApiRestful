package org.serratec.backend.apiRestfulG5.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "endereco", schema = "public")

public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cep", length = 9, nullable = false)
	private String cep;
	
	@Column(name = "rua", length = 100, nullable = false)
	private String rua;
	
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	@Column(name = "complemento", length = 20, nullable = false)
	private String complemento;

	@Column(name = "bairro", length = 50, nullable = false)
	private String bairro;
	
	@Column(name = "cidade", length = 30, nullable = false)
	private String cidade;
	
	@Column(name = "estado", length = 2, nullable = false)
	private String estado;
	
	@OneToMany(mappedBy = "endereco")
	private List<Cliente> cliente;
	
	public Endereco() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", clientes="
				+ cliente + "]";
	}
	
	
}
