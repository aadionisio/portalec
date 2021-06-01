package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.Marca;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;

	
	//construtor padrao
	public MarcaResponse() {
	}
	// construtor com campos
	public MarcaResponse(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	//construtor com entidade
	public MarcaResponse(Marca entity) {
		id = entity.getId();
		nome = entity.getNome();
	}
	



}
