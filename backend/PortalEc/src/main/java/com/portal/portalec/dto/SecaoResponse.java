package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.Secao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecaoResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;

	
	//construtor padrao
	public SecaoResponse() {
	}
	
	public SecaoResponse(Long id, String nome) {
	
		this.id = id;
		this.nome = nome;
	}

	public SecaoResponse(Secao entity) {
		
		id = entity.getId();
		nome = entity.getNome();
	}	
}
