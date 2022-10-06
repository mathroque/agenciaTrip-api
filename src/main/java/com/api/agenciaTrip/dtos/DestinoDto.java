package com.api.agenciaTrip.dtos;

import javax.validation.constraints.NotBlank;

public class DestinoDto {

	@NotBlank
	private String titulo;

	@NotBlank
	private String descricao;

	@NotBlank
	private String imagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
