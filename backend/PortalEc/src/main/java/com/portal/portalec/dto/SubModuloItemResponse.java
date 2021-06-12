package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.SubModuloItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubModuloItemResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String caminhorota;
	
	//construtor padrao
	public SubModuloItemResponse() {
	}
	
	public SubModuloItemResponse(Long id, String nome, String caminhorota) {
	
		this.id = id;
		this.nome = nome;
		this.caminhorota = caminhorota;
	}

	public SubModuloItemResponse(SubModuloItem entity) {
		
		id = entity.getId();
		nome = entity.getNome();
		caminhorota = entity.getCaminhorota();
	}
}
