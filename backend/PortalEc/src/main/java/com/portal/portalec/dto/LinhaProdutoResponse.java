package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.LinhaProduto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinhaProdutoResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;

	
	//construtor padrao
	public LinhaProdutoResponse() {
	}
	// construtor com campos
	public LinhaProdutoResponse(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	//construtor com entidade
	public LinhaProdutoResponse(LinhaProduto entity) {
		id = entity.getId();
		nome = entity.getNome();

	}
}
