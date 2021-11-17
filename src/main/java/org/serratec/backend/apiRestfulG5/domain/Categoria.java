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
	@Table(name = "", schema = "public")
	public class Categoria {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id_categoria;

		@Column(name = "nome", length = 30, nullable = false)
		private String nome;

		@Column(name = "descricao", length = 100, nullable = false)
		private String descricao;
		
		@OneToMany
		(mappedBy = "id_produto")
		private List<Produto> produto;

		public Integer getId_categoria() {
			return id_categoria;
		}

		public void setId_categoria(Integer id_categoria) {
			this.id_categoria = id_categoria;
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
		
		@Override
		public int hashCode() {
			return Objects.hash(id_categoria);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Categoria other = (Categoria) obj;
			return Objects.equals(id_categoria, other.id_categoria);
		}
}
