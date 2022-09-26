package com.api.agenciaTrip.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PromocaoDto {

	@NotBlank
	private String pais;
	@NotBlank
	private String cidade;
	@NotNull
	private Integer desconto;
	@NotNull
	private Double valor;
	@NotNull
	private Integer ano;
	@NotBlank
	private String imagem;
	@NotBlank
	private String continente;

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

}
