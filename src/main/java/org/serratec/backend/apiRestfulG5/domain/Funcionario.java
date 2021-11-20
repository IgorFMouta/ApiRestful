package org.serratec.backend.apiRestfulG5.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario", schema = "public")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_funcionario;
	
	@Column (name = "nome_funcionario", length = 100, nullable = false)
	private String nome;
	
	@Column (name = "cpf_funcionario", length = 15, unique = true, nullable = false)
	private String cpf;
		
	public Integer getId() {
		return id_funcionario;
	}

	public void setId(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id_funcionario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id_funcionario, other.id_funcionario);
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id_funcionario + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
}
