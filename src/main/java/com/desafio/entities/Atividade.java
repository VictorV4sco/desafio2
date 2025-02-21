package com.desafio.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private Double preco;
	
	@ManyToMany(mappedBy = "atividades")
	private Set<Participante> participantes = new HashSet<Participante>();
	
	@ManyToOne
	@JoinColumn(name = "categorias_id")
	private Categoria categorias;
	
	@OneToMany(mappedBy = "atividades")
	private Set<Bloco> blocos = new HashSet<Bloco>();
	
	public Atividade() {
	}

	public Atividade(Long id, String nome, String descricao, Double preco, Set<Participante> participantes,
			Categoria categorias, Set<Bloco> blocos) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.participantes = participantes;
		this.categorias = categorias;
		this.blocos = blocos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

	public Categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	public Set<Bloco> getBlocos() {
		return blocos;
	}

	public void setBlocos(Set<Bloco> blocos) {
		this.blocos = blocos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(blocos, categorias, descricao, id, nome, participantes, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(blocos, other.blocos) && Objects.equals(categorias, other.categorias)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(participantes, other.participantes)
				&& Objects.equals(preco, other.preco);
	}

}
