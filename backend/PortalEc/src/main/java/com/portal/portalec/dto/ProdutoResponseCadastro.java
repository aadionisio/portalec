package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.Produto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProdutoResponseCadastro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codprod;
	private String descricao;

	
	//construtor padrao
	public ProdutoResponseCadastro() {
	}
	// construtor com campos
	public ProdutoResponseCadastro(Long id, String nome) {
		this.codprod = id;
		this.descricao = nome;
	}
	
	//construtor com entidade
	public ProdutoResponseCadastro(Produto entity) {
		codprod = entity.getId();
		descricao = entity.getDescricao();
	}	
	
}