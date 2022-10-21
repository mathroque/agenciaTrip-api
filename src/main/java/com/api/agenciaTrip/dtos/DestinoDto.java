package com.api.agenciaTrip.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DestinoDto {

	@NotBlank
	private String destino;

	@NotBlank
	private String origem;

	@NotBlank
	private String imagem;
	
	@NotNull
	private Double valor;

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
