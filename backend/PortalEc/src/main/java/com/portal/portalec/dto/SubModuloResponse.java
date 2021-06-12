package com.portal.portalec.dto;

import java.io.Serializable;

import com.portal.portalec.entities.SubModulo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubModuloResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String caminhorota;
	
	//construtor padrao
	public SubModuloResponse() {
	}
	
	public SubModuloResponse(Long id, String nome, String caminhorota ) {
		this.id = id;
		this.nome = nome;
		this.caminhorota = caminhorota;
	}

	public SubModuloResponse(SubModulo entity) {
		
		id = entity.getId();
		nome = entity.getNome();
		caminhorota = entity.getCaminhorota();
	}	

}
