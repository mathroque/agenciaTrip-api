package com.api.agenciaTrip.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_destino")
public class DestinoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String destino;
	@Column(nullable = false)
	private String origem;
	@Column(nullable = false)
	private String imagem;
	@Column(nullable = false)
	private Double valor;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String titulo) {
		this.destino = titulo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String descricao) {
		this.origem = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}