package com.desafio.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Instant inicio;
	
	@Column
	private Instant fim;
	
	@ManyToOne
	@JoinColumn(name = "atividades_id")
	private Atividade atividades;
	
	public Bloco() {
	}

	public Bloco(Long id, Instant inicio, Instant fim, Atividade atividades) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.atividades = atividades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInicio() {
		return inicio;
	}

	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public void setFim(Instant fim) {
		this.fim = fim;
	}

	public Atividade getAtividades() {
		return atividades;
	}

	public void setAtividades(Atividade atividades) {
		this.atividades = atividades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atividades, fim, id, inicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloco other = (Bloco) obj;
		return Objects.equals(atividades, other.atividades) && Objects.equals(fim, other.fim)
				&& Objects.equals(id, other.id) && Objects.equals(inicio, other.inicio);
	}

}
