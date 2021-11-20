package org.serratec.backend.apiRestfulG5.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto", schema = "public")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;

	@Column(name = "qtd_estoque", nullable = false)
	private Integer qtd_estoque;

	@Column(name = "data_cadastro", nullable = false)
	private Date data_cadastro;

	@Column(name = "valor_unitario", nullable = false)
	private Float valor_unitario;

	@Column(name = "image", nullable = true)
	private byte[] image;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name = "funcionario_produto", joinColumns = 
	@JoinColumn(name = "id_produto"),
	inverseJoinColumns = @JoinColumn(name = "id_funcionario"))
	private List<Funcionario> funcionario;
	
	
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
		return qtd_estoque;
	}

	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
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
	
	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
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

	

	

}
