package org.serratec.backend.apiRestfulG5.domain;

import java.util.Date;
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
@Table(name = "", schema = "public")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;

	@Column(name = "Qtd_estoque", length = 100, nullable = false)
	private Integer Qtd_estoque;

	@Column(name = "data_cadastro", nullable = false)
	private Date data_cadastro;

	@Column(name = "valor_unitario", nullable = false)
	private Float valor_unitario;

	@Column(name = "image")
	private byte[] image;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Produto() {
		super();
	}

	public Integer getId() {
		return id_produto;
	}

	public void setId(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtd_estoque() {
		return Qtd_estoque;
	}

	public void setQtd_estoque(Integer qtd_estoque) {
		Qtd_estoque = qtd_estoque;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Float getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(Float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id_produto, other.id_produto);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id_produto + ", nome=" + nome + ", descricao=" + descricao + ", Estoque=" + Qtd_estoque
				+ ", Cadastroc=" + data_cadastro + "valor="+ valor_unitario +"]";
	}

}
